package ru.skypro.homework.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.utils.CommentDtoWithHttpStatus;

public interface CommentsService {
    CommentsDto findCommentsRelatedToAd(int id);

    CommentDtoWithHttpStatus addComment(int id, String username, CreateOrUpdateCommentDto createOrUpdateCommentDto);

    ResponseEntity<HttpStatus> deleteComment(long adId, long commentId, String userName);

    CommentDtoWithHttpStatus updateComment(long adId, long commentId, String userName,
                                           CreateOrUpdateCommentDto updatedCommentDto);
}
