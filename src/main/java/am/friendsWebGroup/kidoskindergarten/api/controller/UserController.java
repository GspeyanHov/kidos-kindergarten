package am.friendsWebGroup.kidoskindergarten.api.controller;

import am.friendsWebGroup.kidoskindergarten.api.UserApi;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.ResponseUserDto;
import am.friendsWebGroup.kidoskindergarten.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<ResponseUserDto> registerUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(CREATED).body(userService.saveUser(createUserDto));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        return ResponseEntity.ok(userService.login(authRequestDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> findUserById(@PathVariable ("id") int id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
