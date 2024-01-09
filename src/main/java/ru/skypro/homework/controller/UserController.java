package ru.skypro.homework.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.service.impl.UserServiceImpl;

import java.security.Principal;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@Data
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * <h2>Получение информации об авторизованном пользователе</h2>
     *       operationId: getUser
     *
     * @return responses:
     *      '200': content:
     *      application/json: User, description: OK
     *      <br>'401': description: Unauthorized
     */
    @GetMapping("/me")
    @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<UserDto> getInformationUser(Principal principal) {
        logger.info("Principal.name: " + principal.getName());
        return ResponseEntity.ok(userService.getInfoUser(principal.getName()));

    }

    /*
    PATCH /users/me         + below
    PATCH /users/me/image   + in AvatarController
     */
    @PatchMapping("/me")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UpdateUserDto updateUserDto,
                                                 Principal principal) {
        logger.info("updateUser invoked");
        return userService.updateUser(updateUserDto, principal);
    }
}
