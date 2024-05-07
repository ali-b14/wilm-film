package com.wilmfilm.app.domain;

import static com.wilmfilm.app.domain.VideoTestSamples.*;
import static com.wilmfilm.app.domain.WatchLaterTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.wilmfilm.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class WatchLaterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(WatchLater.class);
        WatchLater watchLater1 = getWatchLaterSample1();
        WatchLater watchLater2 = new WatchLater();
        assertThat(watchLater1).isNotEqualTo(watchLater2);

        watchLater2.setId(watchLater1.getId());
        assertThat(watchLater1).isEqualTo(watchLater2);

        watchLater2 = getWatchLaterSample2();
        assertThat(watchLater1).isNotEqualTo(watchLater2);
    }

    @Test
    void videoTest() throws Exception {
        WatchLater watchLater = getWatchLaterRandomSampleGenerator();
        Video videoBack = getVideoRandomSampleGenerator();

        watchLater.setVideo(videoBack);
        assertThat(watchLater.getVideo()).isEqualTo(videoBack);

        watchLater.video(null);
        assertThat(watchLater.getVideo()).isNull();
    }
}
