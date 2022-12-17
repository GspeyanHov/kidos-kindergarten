package am.friendsWebGroup.kidoskindergarten.api.controller;

import am.friendsWebGroup.kidoskindergarten.api.KidApi;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.CreateKidRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidResponseDto;
import am.friendsWebGroup.kidoskindergarten.service.KidServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/kid")
public class KidController implements KidApi {

    private final KidServiceImpl kidService;

    @Override
    @PostMapping()
    public ResponseEntity<KidResponseDto> registerKid(@RequestBody CreateKidRequestDto createKidDto) {
        return ResponseEntity.status(CREATED).body(kidService.saveKid(createKidDto));
    }
}
