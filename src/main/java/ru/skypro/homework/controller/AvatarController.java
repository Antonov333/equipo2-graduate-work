package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.utils.AdFound;
import ru.skypro.homework.service.AdvertisementsService;
import ru.skypro.homework.service.UserService;

import java.io.IOException;
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
public class AvatarController {
    private final UserService userService;
    private final AdvertisementsService advertisementsService;

    public AvatarController(UserService userService, AdvertisementsService advertisementsService) {
        this.userService = userService;
        this.advertisementsService = advertisementsService;
    }
    @PostMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> changeAvatar(@RequestBody MultipartFile avatar) throws IOException {
        userService.setAvatar(avatar);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/images/{id}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE})// "images/*"})
    public ResponseEntity<AdFound> getImage(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok(advertisementsService.getAdById(id));
    }

}
