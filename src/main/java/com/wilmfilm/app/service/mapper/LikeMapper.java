package com.wilmfilm.app.service.mapper;

import com.wilmfilm.app.domain.Like;
import com.wilmfilm.app.domain.User;
import com.wilmfilm.app.domain.Video;
import com.wilmfilm.app.service.dto.LikeDTO;
import com.wilmfilm.app.service.dto.UserDTO;
import com.wilmfilm.app.service.dto.VideoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Like} and its DTO {@link LikeDTO}.
 */
@Mapper(componentModel = "spring")
public interface LikeMapper extends EntityMapper<LikeDTO, Like> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userId")
    @Mapping(target = "video", source = "video", qualifiedByName = "videoId")
    LikeDTO toDto(Like s);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);

    @Named("videoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VideoDTO toDtoVideoId(Video video);
}
