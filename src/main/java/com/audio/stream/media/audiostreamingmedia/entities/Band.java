package com.audio.stream.media.audiostreamingmedia.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BAND")
@Cacheable
public class Band extends AuditableEntity<Band> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @OneToMany
    @JoinTable(name = "BAND_SONGS_GENRE", joinColumns = {@JoinColumn(name = "BAND_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")})
    private Set<Genre> genres;

    @OneToMany
    @JoinTable(name = "BAND_SONG_ARTISTS", joinColumns = {@JoinColumn(name = "BAND_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID")})
    private Set<Artist> artists;

    @OneToMany
    @JoinTable(name = "SONGS_BAND_ALBUM", joinColumns = {@JoinColumn(name = "BAND_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID")})
    private List<Album> albums;

    @OneToMany
    @JoinTable(name = "BAND_SONGS", joinColumns = {@JoinColumn(name = "BAND_ID", referencedColumnName = "ID")},
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
