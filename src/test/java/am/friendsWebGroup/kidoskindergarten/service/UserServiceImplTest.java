package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.MockData;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.exception.AuthenticationException;
import am.friendsWebGroup.kidoskindergarten.mapper.UserMapper;
import am.friendsWebGroup.kidoskindergarten.repository.UserRepository;
import am.friendsWebGroup.kidoskindergarten.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @Test
    void shouldCreateAuthenticationResponse() {
        //given
        AuthRequestDto requestDto = MockData.authRequestDto();
        User user = MockData.getEnabledUser();
        AuthResponseDto expected = MockData.authResponseDto();

        //when
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(anyString(), eq(user.getPassword()))).thenReturn(true);
        when(jwtTokenUtil.generateToken(anyString())).thenReturn(expected.getToken());
        AuthResponseDto actual = userService.login(requestDto);

        //then
        assertNotNull(actual);
        assertEquals(expected.getToken(), actual.getToken());
    }

    @Test
    void shouldThrowExceptionAsEmailDoesNotExist() {
        //given
        AuthRequestDto requestDto = MockData.authRequestDto();

        //when
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        //then
        assertThrows(AuthenticationException.class, () -> userService.login(requestDto));
    }

    @Test
    void shouldThrowExceptionAsPasswordsDoNotMatch() {
        //given
        AuthRequestDto requestDto = MockData.authRequestDto();
        User user = MockData.getEnabledUser();

        //when
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(anyString(), eq(user.getPassword()))).thenReturn(false);

        //then
        assertThrows(AuthenticationException.class, () -> userService.login(requestDto));
    }

    @Test
    void shouldThrowExceptionAsUserIsDisabled() {
        //given
        AuthRequestDto requestDto = MockData.authRequestDto();
        User user = MockData.getDisabledUser();

        //when
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(anyString(), eq(user.getPassword()))).thenReturn(true);

        //then
        assertThrows(AuthenticationException.class, () -> userService.login(requestDto));
    }
}