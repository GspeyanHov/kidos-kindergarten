package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.BabySitterUserResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.BabysitterResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.CreateBabysitterRequestDto;
import am.friendsWebGroup.kidoskindergarten.entity.Babysitter;
import am.friendsWebGroup.kidoskindergarten.entity.Role;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.exception.AuthorizationException;
import am.friendsWebGroup.kidoskindergarten.exception.BabysitterRegistrationFailureException;
import am.friendsWebGroup.kidoskindergarten.exception.Error;
import am.friendsWebGroup.kidoskindergarten.mapper.BabysitterMapper;
import am.friendsWebGroup.kidoskindergarten.repository.BabysitterRepository;
import am.friendsWebGroup.kidoskindergarten.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static am.friendsWebGroup.kidoskindergarten.entity.Role.BABYSITTER;
import static am.friendsWebGroup.kidoskindergarten.entity.Role.PARENT;
import static am.friendsWebGroup.kidoskindergarten.exception.Error.PERMISSION_DENIED;

@Slf4j
@Service
@RequiredArgsConstructor
public class BabysitterServiceImpl implements BabysitterService {

    private final BabysitterRepository babysitterRepository;
    private final BabysitterMapper babysitterMapper;


    @Override
    public BabysitterResponseDto saveBabysitter(CreateBabysitterRequestDto createBabysitterRequestDto) {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Babysitter babysitter = babysitterMapper.mapToEntity(createBabysitterRequestDto);
        if (!user.getUser().isEnable() || user.getUser().getRole() == PARENT || user.getUser().getRole() == BABYSITTER) {
            throw new AuthorizationException(PERMISSION_DENIED);
        }
        if (babysitter == null) {
            throw new BabysitterRegistrationFailureException(Error.BABYSITTER_NOT_SAVED);
        }
        babysitter.setUser(user.getUser());
        user.getUser().setRole(BABYSITTER);
        BabysitterResponseDto babysitterResponseDto = null;
        babysitterRepository.save(babysitter);
        log.info("New babysitter registered {}", babysitter.getEmail());
        babysitterResponseDto = babysitterMapper.mapToDto(babysitter);
        babysitterResponseDto.setBabySitterUserResponseDto(BabySitterUserResponseDto.builder()
                .id(user.getUser().getId())
                .build());

        return babysitterResponseDto;
    }
}
