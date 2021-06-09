package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Artist;
import com.audio.stream.media.audiostreamingmedia.repository.ArtistsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    private final ArtistsRepository artistsRepository;

    public ArtistsServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @Override
    public List<Artist> findAll() {
        return artistsRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistsRepository.findById(id);
    }

    @Override
    public Artist save(Artist artist) {
        return artistsRepository.save(artist);
    }

    @Override
    public Optional<Artist> findByName(String name) {
        return artistsRepository.findByName(name);
    }

    @Override
    public void saveAll(List<Artist> artists) {
        artistsRepository.saveAll(artists);
    }
}
