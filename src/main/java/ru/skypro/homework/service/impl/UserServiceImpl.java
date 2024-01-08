package ru.skypro.homework.service.impl;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AvatarDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.mapping.UserMapper;
import ru.skypro.homework.model.Images;
import ru.skypro.homework.model.PictureType;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.ImagesRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final ImagesRepository imagesRepository;

    /** Not used in current version
     * @param user
     * @return
     */
    @Override
    public UserDto saveUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto deleteUser(UserDto user) {
        logger.info("deleting user not supported by current version");
        return null;
    }

    /**
     * @return
     */
    @Override
    public UserDto getInfoUser(String userName) {
        logger.info("getInfoUser || userName: " + userName);
        if (userName.isEmpty()) {
            return new UserDto();
        }
        Optional<User> userOptional = userRepository.findByEmail(userName);

        logger.info("getInfoUser | userOptional is present? -- see next line");
        logger.info(" " + userOptional.isPresent());

        if (userOptional.isEmpty()) {
            return new UserDto();
        } else {
            logger.info(userOptional.get().toString());
            return UserMapper.INSTANCE.userToDto(userOptional.get());
        }
    }

    @Override
    public UpdateUserDto setInfoUser(UpdateUserDto updateUserDto) {
        return null;
    }

    @Override
    public AvatarDto setAvatar(MultipartFile avatar) throws IOException {
        return null;
    }

    public ResponseEntity<HttpStatus> setAvatar(MultipartFile avatarSourceFile, Principal principal) throws IOException {
        String avatarsDir = "/avatars";

        if (avatarSourceFile == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (principal == null) {
            logger.info("setAvatar: principal is empty");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (userRepository.findByEmail(principal.getName()).isEmpty()) {
            logger.info("setAvatar: user is not registered: " + principal.getName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User user = userRepository.findByEmail(principal.getName()).get();
        Images avatarPicture = Images.builder()
                .userId(user.getId())
                .pictureType(PictureType.USER_AVATAR)
                .mediaType(avatarSourceFile.getContentType())
                .data(avatarSourceFile.getBytes())
                .build();

        avatarPicture = imagesRepository.save(avatarPicture);

        user.setIdImage("/images/" + avatarPicture.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


}
