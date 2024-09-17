package ru.skypro.homework.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NewAdDtoWithMultiPartFile {
    MultipartFile image;
    CreateOrUpdateAdDto properties;
}