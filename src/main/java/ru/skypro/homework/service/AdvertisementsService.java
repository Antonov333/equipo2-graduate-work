package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.utils.AdFound;
import ru.skypro.homework.model.utils.ImageProcessResult;

import java.io.IOException;
import java.security.Principal;

public interface AdvertisementsService {
    AdsDto getAll();

    AdDto addNewAd(CreateOrUpdateAdDto ad, String image, Principal principal);

    AdFound getAdById(long id);

    AdFound removeAd(long id, String userLoginName);

    boolean isAdmin(String userLoginName);

    ResponseEntity<AdsDto> getAdsDtoByUserLoginName(String userLogin);

    ResponseEntity<AdDto> updateAd(long id, CreateOrUpdateAdDto updatedAdContent, String userLoginName);

    ImageProcessResult getPhotoByAdId(long id);

    byte[] updateImageAd(Integer id, MultipartFile image) throws IOException;
}
