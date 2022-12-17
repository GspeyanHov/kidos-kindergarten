package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.kidDto.CreateKidRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidResponseDto;

public interface KidService {

   KidResponseDto saveKid( CreateKidRequestDto createKidRequestDto);
}
