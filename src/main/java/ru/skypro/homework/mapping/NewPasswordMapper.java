package ru.skypro.homework.mapping;

import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.model.utils.NewPassword;

public interface NewPasswordMapper {
    NewPasswordMapper INSTANCE = Mappers.getMapper(NewPasswordMapper.class);
   // NewPasswordDto newPasswordToDto (NewPassword newPassword);

    NewPasswordDto newPasswordToDto(String currentPassword, String newPassword);
}
