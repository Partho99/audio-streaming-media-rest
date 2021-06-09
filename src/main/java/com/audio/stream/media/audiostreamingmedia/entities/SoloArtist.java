package com.audio.stream.media.audiostreamingmedia.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "SOLO_ARTIST")
public class SoloArtist extends AuditableEntity<SoloArtist> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    @ManyToOne
    @JoinTable(name = "SOLO_ARTIST_SONG", joinColumns = {@JoinColumn(name = "SOLO_ARTIS_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SONG_ID", referencedColumnName = "ID")})
    private Song song;

    @OneToMany
    @JoinTable(name = "SOLO_SONG_LABEL", joinColumns = {@JoinColumn(name = "SOLO_ARTIST_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "LABEL_ID", referencedColumnName = "ID")})
    private Set<Label> labels;

    @OneToMany
    @JoinTable(name = "SOLO_SONG_GENRE", joinColumns = {@JoinColumn(name = "SOLO_ARTIST_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")})
    private Set<Genre> genres;

    @OneToMany
    @JoinTable(name = "SOLO_ARTIST_SONGS", joinColumns = {@JoinColumn(name = "SOLO_ARTIST_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SONG_ID", referencedColumnName = "ID")})
    private Collection<Song> songs;

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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void setSongs(Collection<Song> songs) {
        this.songs = songs;
    }
}
