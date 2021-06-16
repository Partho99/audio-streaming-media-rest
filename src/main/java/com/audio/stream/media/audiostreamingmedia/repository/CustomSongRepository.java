package com.audio.stream.media.audiostreamingmedia.repository;

import com.audio.stream.media.audiostreamingmedia.entities.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomSongRepository {
    @Query("select  s from Song s inner join s.genres g on g.id = s.id where g.name='romantic'")
    List<Song> findByGenre();
}
