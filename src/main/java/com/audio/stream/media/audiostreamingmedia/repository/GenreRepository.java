package com.audio.stream.media.audiostreamingmedia.repository;

import com.audio.stream.media.audiostreamingmedia.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByNameContaining(String name);
}
