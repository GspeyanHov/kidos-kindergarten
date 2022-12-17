package am.friendsWebGroup.kidoskindergarten.api.controller;

import am.friendsWebGroup.kidoskindergarten.api.BabysitterApi;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.BabysitterResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.CreateBabysitterRequestDto;
import am.friendsWebGroup.kidoskindergarten.service.BabysitterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/babysitters")
public class BabysitterController implements BabysitterApi {

    private final BabysitterServiceImpl babysitterService;

    @Override
    @PostMapping()
    public ResponseEntity<BabysitterResponseDto> registerBabysitter(@RequestBody CreateBabysitterRequestDto createBabysitterRequestDto) {
        return ResponseEntity.status(CREATED).body(babysitterService.saveBabysitter(createBabysitterRequestDto));
    }
}
