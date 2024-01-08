package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.exception.NotAllowedPasswordException;
import ru.skypro.homework.service.impl.NewPasswordImpl;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class NewPasswordController {

    private final NewPasswordImpl newPasswordService;

    private final Logger logger = LoggerFactory.getLogger(NewPasswordImpl.class);

    @PostMapping("/set_password")
    public ResponseEntity<Void> setPassword(@RequestBody NewPasswordDto newPasswordDto, Authentication authentication) {
        if (newPasswordDto.getNewPassword().length() <= 8 || newPasswordDto.getNewPassword().length() >= 16) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (authentication.getName() != null) {
            newPasswordService.setPassword(newPasswordDto.getCurrentPassword(), newPasswordDto.getNewPassword(), authentication);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
