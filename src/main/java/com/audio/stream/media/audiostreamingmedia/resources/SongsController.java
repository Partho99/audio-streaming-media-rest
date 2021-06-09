package com.audio.stream.media.audiostreamingmedia.resources;

import com.audio.stream.media.audiostreamingmedia.converter.ArtistConverter;
import com.audio.stream.media.audiostreamingmedia.dtos.ArtistDto;
import com.audio.stream.media.audiostreamingmedia.dtos.MovieSongsDetailsDto;
import com.audio.stream.media.audiostreamingmedia.dtos.SongDetailsDto;
import com.audio.stream.media.audiostreamingmedia.entities.Artist;
import com.audio.stream.media.audiostreamingmedia.entities.Genre;
import com.audio.stream.media.audiostreamingmedia.entities.Movie;
import com.audio.stream.media.audiostreamingmedia.entities.Song;
import com.audio.stream.media.audiostreamingmedia.service.ArtistsService;
import com.audio.stream.media.audiostreamingmedia.service.GenreService;
import com.audio.stream.media.audiostreamingmedia.service.MovieService;
import com.audio.stream.media.audiostreamingmedia.service.SongsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/songs")
public class SongsController {

    private final SongsService songsService;
    private final ArtistsService artistsService;
    private final ArtistConverter artistConverter;
    private final MovieService movieService;
    private final GenreService genreService;

    public SongsController(SongsService songsService, ArtistsService artistsService,
                           ArtistConverter artistConverter, MovieService movieService, GenreService genreService) {
        this.songsService = songsService;
        this.artistsService = artistsService;
        this.artistConverter = artistConverter;
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @PostMapping("/save-song")
    public void saveSong(@RequestBody SongDetailsDto songDetailsDto) {
        Song song = new Song();
        List<Artist> artists = songDetailsDto.getArtists();

        song.setName(songDetailsDto.getName());
        song.setUrl(songDetailsDto.getUrl());
        song.setImageUrl(songDetailsDto.getImageUrl());
        song.setSlug(songDetailsDto.getSlug());
        song.setActiveStatus(songDetailsDto.getActiveStatus());

        songsService.save(song);
        artists.forEach(s -> s.setSong(song));
        artistsService.saveAll(artists);

    }


    @PostMapping("/save-movie-songs")
    public void saveMovieSongs(@RequestBody MovieSongsDetailsDto movieSongsDetailsDto) {
        Movie movie = new Movie();
        List<Song> songs = movieSongsDetailsDto.getSongs();
        Set<Genre> genres =  movieSongsDetailsDto.getGenres();

        movie.setName(movieSongsDetailsDto.getName());
        movie.setImageUrl(movieSongsDetailsDto.getImageUrl());
        movie.setAlbum(movieSongsDetailsDto.getAlbum());
        movie.setSongs(songs);
        movie.setGenres(genres);
        movie.setActiveStatus(movieSongsDetailsDto.getActiveStatus());

        System.out.println(movieSongsDetailsDto.getAlbum());

        genreService.saveAll(genres);
        movieService.save(movie);


    }

    @GetMapping("/show-song")
    public List<Song> showSongs() {
        return songsService.findAll();
    }

    public List<SongDetailsDto> showSongDetails() {
        return null;
    }

    @GetMapping("/show-artists")
    public List<ArtistDto> showAllArtist() {
        List<Artist> artists = artistsService.findAll();
        List<ArtistDto> artistDtos = artistConverter.entityToDto(artists);
        return artistDtos;
    }

    /**
     * next day should implement list of entry show using search
     */
    @GetMapping("/show-movie/{name}")
    public Optional<Movie> showMovie(@PathVariable String name) {
        return movieService.findByName(name);
    }
}
