package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Song;
import com.audio.stream.media.audiostreamingmedia.repository.SongsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsServiceImpl implements SongsService {

    private final SongsRepository songsRepository;

    public SongsServiceImpl(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }


    @Override
    public List<Song> findAll() {
        return songsRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songsRepository.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songsRepository.save(song);
    }

    @Override
    public Optional<Song> findByName(String name) {
        return songsRepository.findByName(name);
    }
}
