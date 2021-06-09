package com.audio.stream.media.audiostreamingmedia.dtos;

import com.audio.stream.media.audiostreamingmedia.entities.Album;
import com.audio.stream.media.audiostreamingmedia.entities.Genre;
import com.audio.stream.media.audiostreamingmedia.entities.Song;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class MovieSongsDetailsDto {

    private Long id;
    private String name;
    private String imageUrl;
    private Date releaseDate;
    private Boolean activeStatus;

    private List<Song> songs;
    private Album album;
    private Set<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
