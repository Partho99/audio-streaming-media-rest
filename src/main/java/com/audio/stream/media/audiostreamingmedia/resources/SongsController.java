package com.audio.stream.media.audiostreamingmedia.resources;

import com.audio.stream.media.audiostreamingmedia.converter.ArtistConverter;
import com.audio.stream.media.audiostreamingmedia.dtos.ArtistDto;
import com.audio.stream.media.audiostreamingmedia.dtos.MovieSongsDetailsDto;
import com.audio.stream.media.audiostreamingmedia.dtos.SongDetailsDto;
import com.audio.stream.media.audiostreamingmedia.entities.*;
import com.audio.stream.media.audiostreamingmedia.repository.SongsRepository;
import com.audio.stream.media.audiostreamingmedia.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
public class SongsController {

    private final SongsService songsService;
    private final ArtistsService artistsService;
    private final ArtistConverter artistConverter;
    private final MovieService movieService;
    private final GenreService genreService;
    private final AlbumService albumService;

    public SongsController(SongsService songsService, ArtistsService artistsService,
                           ArtistConverter artistConverter, MovieService movieService,
                           GenreService genreService, AlbumService albumService) {
        this.songsService = songsService;
        this.artistsService = artistsService;
        this.artistConverter = artistConverter;
        this.movieService = movieService;
        this.genreService = genreService;
        this.albumService = albumService;
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
        List<Genre> genres = movieSongsDetailsDto.getGenres();
        List<Artist> artists = movieSongsDetailsDto.getArtists();

        Album album = movieSongsDetailsDto.getAlbum();
        movie.setName(movieSongsDetailsDto.getName());
        movie.setImageUrl(movieSongsDetailsDto.getImageUrl());
        movie.setAlbum(movieSongsDetailsDto.getAlbum());
        movie.setSongs(songs);
        movie.setGenres(genres);
        movie.setActiveStatus(movieSongsDetailsDto.getActiveStatus());


        songsService.saveAll(songs);
        artistsService.saveAll(artists);
        genreService.saveAll(genres);
        albumService.save(album);
        movieService.save(movie);


    }

    @GetMapping("/show-song")
    public List<Song> showSongs() {
        return songsService.findAll();
    }

    @GetMapping("/show-genre")
    public List<Song> showGenre() {
        return songsService.genreFind();
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

    @GetMapping("/show-albums/{albumName}")
    public List<Album> showSearchedAlbums(@PathVariable String albumName) {
        return albumService.findByName(albumName);
    }
}
