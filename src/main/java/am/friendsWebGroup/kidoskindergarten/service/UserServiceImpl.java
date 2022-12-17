package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.ResponseUserDto;
import am.friendsWebGroup.kidoskindergarten.entity.Role;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.exception.AuthenticationException;
import am.friendsWebGroup.kidoskindergarten.exception.UserNotFoundException;
import am.friendsWebGroup.kidoskindergarten.mapper.UserMapper;
import am.friendsWebGroup.kidoskindergarten.repository.UserRepository;
import am.friendsWebGroup.kidoskindergarten.util.JwtTokenUtil;
import am.friendsWebGroup.kidoskindergarten.validation.validator.UserValidator;
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

    private final UserValidator userValidator;
    private final MailService mailService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseUserDto saveUser(CreateUserDto dto) {
        User user = userMapper.mapToEntity(dto);
        userValidator.validateUserRegistration(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnable(false);
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);
        log.info("New user registered {}", user.getEmail());
        mailService.sendEmail(user);
        log.info("Verification email was sent to user {}", user.getEmail());
        return userMapper.mapToDto(user);
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

    @Override
    public ResponseUserDto findUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            log.error("user with {} id not found", id);
            throw new UserNotFoundException(NO_SUCH_USER);
        }
        log.info("user with {} id successfully found", id);
        return userMapper.mapToDto(optionalUser.get());
    }
}
