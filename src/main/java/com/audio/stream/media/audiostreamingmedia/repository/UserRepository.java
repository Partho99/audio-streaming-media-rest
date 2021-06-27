package com.audio.stream.media.audiostreamingmedia.repository;

import com.audio.stream.media.audiostreamingmedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User where email=:email")
    User findByEmailOrUsername(@Param("email") String email);
}
