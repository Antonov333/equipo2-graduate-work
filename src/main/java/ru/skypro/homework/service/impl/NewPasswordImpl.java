package ru.skypro.homework.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.mapping.NewPasswordMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.NewPasswordService;

@Service
public class NewPasswordImpl implements NewPasswordService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final NewPasswordMapper newPasswordMapper;

    private final Logger logger = LoggerFactory.getLogger(NewPasswordImpl.class);

    public NewPasswordImpl(UserRepository userRepository, PasswordEncoder encoder, NewPasswordMapper newPasswordMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.newPasswordMapper = newPasswordMapper;
    }


    @Override
    public void setPassword(String currentPassword, String newPassword, Authentication authentication) {
        if (authentication.getName() != null) {
            User user = userRepository.findByUserName(authentication.getName());
            NewPasswordDto newPasswordDto = NewPasswordMapper.INSTANCE.newPasswordToDto(currentPassword,newPassword);
            if (encoder.matches(currentPassword, newPasswordDto.getCurrentPassword())) {
                user.setPassword(encoder.encode(newPassword));
                userRepository.save(user);
            }
        }

    }
}
