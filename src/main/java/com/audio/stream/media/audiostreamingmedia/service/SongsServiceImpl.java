package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Genre;
import com.audio.stream.media.audiostreamingmedia.entities.Song;
import com.audio.stream.media.audiostreamingmedia.repository.SongsRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class SongsServiceImpl implements SongsService {

    private final SongsRepository songsRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public void saveAll(List<Song> songs) {
        songsRepository.saveAll(songs);
    }

    @Override
    public List<Song> genreFind() {
        return songsRepository.findByGenre();
    }

}
