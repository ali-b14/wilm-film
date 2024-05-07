package com.wilmfilm.app.service.mapper;

import static com.wilmfilm.app.domain.VideoMetaDataAsserts.*;
import static com.wilmfilm.app.domain.VideoMetaDataTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoMetaDataMapperTest {

    private VideoMetaDataMapper videoMetaDataMapper;

    @BeforeEach
    void setUp() {
        videoMetaDataMapper = new VideoMetaDataMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getVideoMetaDataSample1();
        var actual = videoMetaDataMapper.toEntity(videoMetaDataMapper.toDto(expected));
        assertVideoMetaDataAllPropertiesEquals(expected, actual);
    }
}
