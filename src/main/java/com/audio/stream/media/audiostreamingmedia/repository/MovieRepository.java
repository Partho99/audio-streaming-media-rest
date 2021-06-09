package com.audio.stream.media.audiostreamingmedia.repository;

import com.audio.stream.media.audiostreamingmedia.entities.Movie;
import com.audio.stream.media.audiostreamingmedia.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByNameContaining(String name);
}
