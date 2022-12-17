package am.friendsWebGroup.kidoskindergarten;

import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.entity.User;

public class MockData {

    public static AuthRequestDto authRequestDto(){
        return AuthRequestDto.builder()
                .email("poxos@mail.ru")
                .password("poxos")
                .build();
    }

    public static AuthResponseDto authResponseDto() {
        return AuthResponseDto.builder()
                .token("some token")
                .build();
    }

    public static User getEnabledUser() {
        return User.builder()
                .name("poxos")
                .surname("poxosyan")
                .email("poxoss@mail.ru")
                .password("poxos")
                .isEnable(true)
                .build();
    }

    public static User getDisabledUser() {
        return User.builder()
                .name("poxos")
                .surname("poxosyan")
                .email("poxoss@mail.ru")
                .isEnable(false)
                .build();
    }
}
