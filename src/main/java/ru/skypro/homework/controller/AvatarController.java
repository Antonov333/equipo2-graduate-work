package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.service.impl.UserServiceImpl;

import java.io.IOException;
import java.security.Principal;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AvatarController {
    private final UserServiceImpl userService;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @PostMapping(value = "users/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<HttpStatus> changeAvatar(@RequestBody MultipartFile image,
                                                   Principal principal) throws IOException {
        logger.info("changeAvatar | user login name: " + principal.getName());
        return userService.setAvatar(image, principal);
    }

    @PatchMapping(value = "users/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<HttpStatus> updateUserImage(@RequestBody MultipartFile image,
                                                      Principal principal) throws IOException {
        logger.info("updateUserImage | user login name: " + principal.getName());
        return userService.setAvatar(image, principal);
    }


}
