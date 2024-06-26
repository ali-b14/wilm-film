package com.wilmfilm.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class WatchLaterAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertWatchLaterAllPropertiesEquals(WatchLater expected, WatchLater actual) {
        assertWatchLaterAutoGeneratedPropertiesEquals(expected, actual);
        assertWatchLaterAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertWatchLaterAllUpdatablePropertiesEquals(WatchLater expected, WatchLater actual) {
        assertWatchLaterUpdatableFieldsEquals(expected, actual);
        assertWatchLaterUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertWatchLaterAutoGeneratedPropertiesEquals(WatchLater expected, WatchLater actual) {
        assertThat(expected)
            .as("Verify WatchLater auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertWatchLaterUpdatableFieldsEquals(WatchLater expected, WatchLater actual) {}

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertWatchLaterUpdatableRelationshipsEquals(WatchLater expected, WatchLater actual) {
        assertThat(expected)
            .as("Verify WatchLater relationships")
            .satisfies(e -> assertThat(e.getVideo()).as("check video").isEqualTo(actual.getVideo()));
    }
}
