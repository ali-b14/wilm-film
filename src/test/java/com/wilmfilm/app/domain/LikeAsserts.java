package com.wilmfilm.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertLikeAllPropertiesEquals(Like expected, Like actual) {
        assertLikeAutoGeneratedPropertiesEquals(expected, actual);
        assertLikeAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertLikeAllUpdatablePropertiesEquals(Like expected, Like actual) {
        assertLikeUpdatableFieldsEquals(expected, actual);
        assertLikeUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertLikeAutoGeneratedPropertiesEquals(Like expected, Like actual) {
        assertThat(expected)
            .as("Verify Like auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertLikeUpdatableFieldsEquals(Like expected, Like actual) {
        assertThat(expected)
            .as("Verify Like relevant properties")
            .satisfies(e -> assertThat(e.getLikedAt()).as("check likedAt").isEqualTo(actual.getLikedAt()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertLikeUpdatableRelationshipsEquals(Like expected, Like actual) {
        assertThat(expected)
            .as("Verify Like relationships")
            .satisfies(e -> assertThat(e.getVideo()).as("check video").isEqualTo(actual.getVideo()));
    }
}
