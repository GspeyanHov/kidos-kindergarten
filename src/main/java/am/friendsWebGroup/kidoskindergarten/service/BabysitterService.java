package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.BabysitterResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.CreateBabysitterRequestDto;

public interface BabysitterService {

    BabysitterResponseDto saveBabysitter(CreateBabysitterRequestDto createBabysitterRequestDto);
}
