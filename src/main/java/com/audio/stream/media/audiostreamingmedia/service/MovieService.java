package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Movie;
import com.audio.stream.media.audiostreamingmedia.entities.Song;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();

    Optional<Movie> findById(Long id);

    Movie save(Movie movie);

    Optional<Movie> findByName(String name);
}
