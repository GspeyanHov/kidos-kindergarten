package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.kidDto.CreateKidRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidParentResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidResponseDto;
import am.friendsWebGroup.kidoskindergarten.entity.Kid;
import am.friendsWebGroup.kidoskindergarten.entity.Role;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.exception.KidRegistrationFailureException;
import am.friendsWebGroup.kidoskindergarten.mapper.KidMapper;
import am.friendsWebGroup.kidoskindergarten.repository.KidRepository;
import am.friendsWebGroup.kidoskindergarten.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static am.friendsWebGroup.kidoskindergarten.entity.Role.USER;
import static am.friendsWebGroup.kidoskindergarten.exception.Error.KID_NOT_SAVED;

@Slf4j
@Service
@RequiredArgsConstructor
public class KidServiceImpl implements KidService {

    private final KidRepository kidRepository;
    private final KidMapper kidMapper;

    @Override
    public KidResponseDto saveKid(CreateKidRequestDto createKidRequestDto) {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = currentUser.getUser();
        Kid kid = kidMapper.mapToEntity(createKidRequestDto);
        kid.setUser(user);

        if (!user.equals(kid.getUser())) {
            throw new KidRegistrationFailureException(KID_NOT_SAVED);
        }
        KidResponseDto kidResponseDto = null;
        if (user.getRole().equals(USER)) {
            user.setRole(Role.PARENT);
            kidRepository.save(kid);
            log.info("new kid was registered by {}", user.getEmail());
            kidResponseDto = kidMapper.mapToDto(kid);
            kidResponseDto.setParent(KidParentResponseDto.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .surname(user.getSurname())
                    .build());
        }
        return kidResponseDto;
    }
}
