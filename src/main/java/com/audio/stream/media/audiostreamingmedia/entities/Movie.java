package com.audio.stream.media.audiostreamingmedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MOVIE")
public class Movie extends AuditableEntity<Movie> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.DETACH)
    @JsonIgnore
    @JoinTable(name = "MOVIE_SONGS_GENRE", joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")})
    private List<Genre> genres;

    @OneToMany
    @JsonIgnore
    @JoinTable(name = "MOVIE_SONGS_LABEL", joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "LABEL_ID", referencedColumnName = "ID")})
    private Set<Label> labels;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "ALBUM_ID")
    private Album album;

    @OneToMany(cascade = CascadeType.DETACH)
    @JsonIgnore
    @JoinTable(name = "MOVIE_SONGS", joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SONG_ID", referencedColumnName = "ID")})
    private List<Song> songs;


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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
