package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();

    Optional<Album> findById(Long id);

    Album save(Album album);

    void saveAll(List<Album> albums);

    List<Album> findByName(String name);
}
