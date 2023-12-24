package ru.skypro.homework.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.model.Comment;

@Mapper
public interface CommentMapper2 {

    CommentMapper2 INSTANCE = Mappers.getMapper(CommentMapper2.class);

    CommentDto commentToDto(Comment comment);

}
