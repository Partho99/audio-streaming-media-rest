package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistsService {

    List<Artist> findAll();

    Optional<Artist> findById(Long id);

    Artist save(Artist artist);

    Optional<Artist> findByName(String name);

    void  saveAll(List<Artist> artists);
}
