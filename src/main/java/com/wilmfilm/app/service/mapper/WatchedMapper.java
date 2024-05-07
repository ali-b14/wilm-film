package com.wilmfilm.app.service.mapper;

import com.wilmfilm.app.domain.User;
import com.wilmfilm.app.domain.Video;
import com.wilmfilm.app.domain.Watched;
import com.wilmfilm.app.service.dto.UserDTO;
import com.wilmfilm.app.service.dto.VideoDTO;
import com.wilmfilm.app.service.dto.WatchedDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Watched} and its DTO {@link WatchedDTO}.
 */
@Mapper(componentModel = "spring")
public interface WatchedMapper extends EntityMapper<WatchedDTO, Watched> {
    @Mapping(target = "video", source = "video", qualifiedByName = "videoId")
    @Mapping(target = "userProfile", source = "userProfile", qualifiedByName = "userId")
    WatchedDTO toDto(Watched s);

    @Named("videoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VideoDTO toDtoVideoId(Video video);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);
}
