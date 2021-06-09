package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Album;
import com.audio.stream.media.audiostreamingmedia.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void saveAll(List<Album> albums) {
        albumRepository.saveAll(albums);
    }

    @Override
    public List<Album> findByName(String name) {
        return albumRepository.findAlbumByNameContaining(name);
    }
}
