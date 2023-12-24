package ru.skypro.homework.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.LoginDto;
import ru.skypro.homework.model.Login;

@Mapper
public interface LoginMapper2 {

    LoginMapper2 INSTANCE = Mappers.getMapper(LoginMapper2.class);

    LoginDto loginToDto(Login login);

}
