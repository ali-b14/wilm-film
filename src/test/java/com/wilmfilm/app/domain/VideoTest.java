package com.wilmfilm.app.domain;

import static com.wilmfilm.app.domain.VideoMetaDataTestSamples.*;
import static com.wilmfilm.app.domain.VideoTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.wilmfilm.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VideoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Video.class);
        Video video1 = getVideoSample1();
        Video video2 = new Video();
        assertThat(video1).isNotEqualTo(video2);

        video2.setId(video1.getId());
        assertThat(video1).isEqualTo(video2);

        video2 = getVideoSample2();
        assertThat(video1).isNotEqualTo(video2);
    }

    @Test
    void metaDataTest() throws Exception {
        Video video = getVideoRandomSampleGenerator();
        VideoMetaData videoMetaDataBack = getVideoMetaDataRandomSampleGenerator();

        video.setMetaData(videoMetaDataBack);
        assertThat(video.getMetaData()).isEqualTo(videoMetaDataBack);

        video.metaData(null);
        assertThat(video.getMetaData()).isNull();
    }
}
