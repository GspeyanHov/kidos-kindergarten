package am.friendsWebGroup.kidoskindergarten.api.controller;

import am.friendsWebGroup.kidoskindergarten.api.UserApi;
import am.friendsWebGroup.kidoskindergarten.dto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(CREATED).body(userService.saveUser(createUserDto));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto) {
        return ResponseEntity.ok(userService.login(authRequestDto));
    }


}
