package com.wilmfilm.app.service.mapper;

import com.wilmfilm.app.domain.User;
import com.wilmfilm.app.domain.Video;
import com.wilmfilm.app.domain.WatchLater;
import com.wilmfilm.app.service.dto.UserDTO;
import com.wilmfilm.app.service.dto.VideoDTO;
import com.wilmfilm.app.service.dto.WatchLaterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link WatchLater} and its DTO {@link WatchLaterDTO}.
 */
@Mapper(componentModel = "spring")
public interface WatchLaterMapper extends EntityMapper<WatchLaterDTO, WatchLater> {
    @Mapping(target = "video", source = "video", qualifiedByName = "videoId")
    @Mapping(target = "userProfile", source = "userProfile", qualifiedByName = "userId")
    WatchLaterDTO toDto(WatchLater s);

    @Named("videoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VideoDTO toDtoVideoId(Video video);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);
}
