package com.wilmfilm.app.repository;

import com.wilmfilm.app.domain.WatchLater;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the WatchLater entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WatchLaterRepository extends JpaRepository<WatchLater, Long> {
    @Query("select watchLater from WatchLater watchLater where watchLater.userProfile.login = ?#{authentication.name}")
    List<WatchLater> findByUserProfileIsCurrentUser();
}
