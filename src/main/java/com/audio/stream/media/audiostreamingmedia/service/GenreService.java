package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GenreService {

    List<Genre> findAll();

    Optional<Genre> findById(Long id);

    Genre save(Genre genre);

    Optional<Genre> findByName(String name);

    void saveAll(List<Genre> genres);
}
