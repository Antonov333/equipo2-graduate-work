package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.service.UserService;
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("http://localhost:8080/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getInformationUser() {
        return ResponseEntity.ok(userService.getInfoUser());
    }
}
