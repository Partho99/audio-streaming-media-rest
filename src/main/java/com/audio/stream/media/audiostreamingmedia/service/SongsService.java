package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Song;

import java.util.List;
import java.util.Optional;


public interface SongsService {

    List<Song> findAll();

    Optional<Song> findById(Long id);

    Song save(Song song);

    Optional<Song> findByName(String name);

    void saveAll(List<Song> songs);

    List<Song> genreFind();

}
