package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.entity.Role;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.exception.AuthenticationException;
import am.friendsWebGroup.kidoskindergarten.exception.EntityDuplicateException;
import am.friendsWebGroup.kidoskindergarten.mapper.UserMapper;
import am.friendsWebGroup.kidoskindergarten.repository.UserRepository;
import am.friendsWebGroup.kidoskindergarten.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static am.friendsWebGroup.kidoskindergarten.exception.Error.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    private final MailService mailService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public User saveUser(CreateUserDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new EntityDuplicateException(DUPLICATE_EMAIL);
        }

        User user = userMapper.mapToEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnable(false);
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);
        log.info("New user registered {}", user.getEmail());
        mailService.sendEmail(user);
        log.info("Verification email was sent to user {}", user.getEmail());
        return user;
    }

    @Override
    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        log.info("Authentication request from {}", authRequestDto.getEmail());
        Optional<User> optionalUser = userRepository.findByEmail(authRequestDto.getEmail());

        if (optionalUser.isEmpty() ||
                !passwordEncoder.matches(authRequestDto.getPassword(),
                        optionalUser.get().getPassword())) {
            log.info("User {} has provided wrong credentials", authRequestDto.getEmail());
            throw new AuthenticationException(BAD_CREDENTIALS);
        }

        User user = optionalUser.get();
        if (!user.isEnable()) {
            log.info("User {} has not confirmed his(her) email", user.getEmail());
            throw new AuthenticationException(NOT_ACTIVE_ACCOUNT);
        }

        log.info("User {} has successfully signed in",user.getEmail());
        return AuthResponseDto.builder()
                .token(jwtTokenUtil.generateToken(user.getEmail()))
                .build();
    }
}
