package com.wilmfilm.app.service.mapper;

import com.wilmfilm.app.domain.Comment;
import com.wilmfilm.app.domain.User;
import com.wilmfilm.app.domain.Video;
import com.wilmfilm.app.service.dto.CommentDTO;
import com.wilmfilm.app.service.dto.UserDTO;
import com.wilmfilm.app.service.dto.VideoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Comment} and its DTO {@link CommentDTO}.
 */
@Mapper(componentModel = "spring")
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {
    @Mapping(target = "author", source = "author", qualifiedByName = "userId")
    @Mapping(target = "video", source = "video", qualifiedByName = "videoId")
    CommentDTO toDto(Comment s);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);

    @Named("videoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VideoDTO toDtoVideoId(Video video);
}
