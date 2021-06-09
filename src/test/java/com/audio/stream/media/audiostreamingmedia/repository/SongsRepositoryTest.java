package com.audio.stream.media.audiostreamingmedia.repository;

import com.audio.stream.media.audiostreamingmedia.ProfileTest;
import com.audio.stream.media.audiostreamingmedia.entities.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ProfileTest
class SongsRepositoryTest {

    @Autowired
    private SongsRepository songsRepository;


    @Test
    void insertSongTest() {
        Song song1 = new Song();

        song1.setName("in the end");
        song1.setSlug("in-the-end");
        song1.setImageUrl("/linkin-park/in-the-end");
        song1.setActiveStatus(true);
        song1.setUrl("/linkin-park/in-the-end");

        songsRepository.save(song1);
        Song song2 = new Song();

        song2.setName("numb");
        song2.setSlug("numb");
        song2.setImageUrl("/linkin-park/numb");
        song2.setActiveStatus(true);
        song2.setUrl("/linkin-park/numb");

        songsRepository.save(song2);


        List<Song> songs = songsRepository.findAll();

        assertEquals(2, songs.size());

    }

    @Test
    void getSongTest(){
        Song song = new Song();
        List<Song> songs  = songsRepository.findAll();
        assertEquals(4,songs.size());
        assertSame(Optional.of(song), songsRepository.findById(2l));
    }
}