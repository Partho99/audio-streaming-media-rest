package com.audio.stream.media.audiostreamingmedia.repository;

import com.audio.stream.media.audiostreamingmedia.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface SongsRepository extends JpaRepository<Song, Long> ,CustomSongRepository {

    @Query("select distinct s from  Song s  where  s.name=?1")
    Optional<Song> findByName(String name);


    @Query(value = "select *  from song  inner join movie_songs ms on song.id = ms.song_id inner join movie m inner join " +
            "movie_songs_genre msg on m.id = msg.movie_id inner join genre g on g.id = msg.genre_id where g.name='romantic'", nativeQuery = true)
    List<Song> findByGenreType(Long x);

}