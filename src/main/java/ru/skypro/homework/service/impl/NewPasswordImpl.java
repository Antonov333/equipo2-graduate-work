package ru.skypro.homework.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.skypro.homework.service.NewPasswordService;

public class NewPasswordImpl implements NewPasswordService {
    private final Logger logger = LoggerFactory.getLogger(NewPasswordImpl.class);
    @Override
    public void setPassword(String currentPassword, String confirmPhoneNumber, String newPassword) {

    }
}
