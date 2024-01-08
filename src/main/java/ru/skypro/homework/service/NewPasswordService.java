package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;

public interface NewPasswordService {

    void setPassword(String currentPassword, String newPassword, Authentication authentication);
}
