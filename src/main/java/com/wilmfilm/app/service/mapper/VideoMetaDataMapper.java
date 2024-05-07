package com.wilmfilm.app.service.mapper;

import com.wilmfilm.app.domain.VideoMetaData;
import com.wilmfilm.app.service.dto.VideoMetaDataDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link VideoMetaData} and its DTO {@link VideoMetaDataDTO}.
 */
@Mapper(componentModel = "spring")
public interface VideoMetaDataMapper extends EntityMapper<VideoMetaDataDTO, VideoMetaData> {}
