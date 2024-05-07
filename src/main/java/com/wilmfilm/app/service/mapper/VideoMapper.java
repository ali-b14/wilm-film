package com.wilmfilm.app.service.mapper;

import com.wilmfilm.app.domain.User;
import com.wilmfilm.app.domain.Video;
import com.wilmfilm.app.domain.VideoMetaData;
import com.wilmfilm.app.service.dto.UserDTO;
import com.wilmfilm.app.service.dto.VideoDTO;
import com.wilmfilm.app.service.dto.VideoMetaDataDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Video} and its DTO {@link VideoDTO}.
 */
@Mapper(componentModel = "spring")
public interface VideoMapper extends EntityMapper<VideoDTO, Video> {
    @Mapping(target = "metaData", source = "metaData", qualifiedByName = "videoMetaDataId")
    @Mapping(target = "uploader", source = "uploader", qualifiedByName = "userId")
    VideoDTO toDto(Video s);

    @Named("videoMetaDataId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VideoMetaDataDTO toDtoVideoMetaDataId(VideoMetaData videoMetaData);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);
}
