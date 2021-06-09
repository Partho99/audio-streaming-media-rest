package com.audio.stream.media.audiostreamingmedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ARTIST")
public class Artist extends AuditableEntity<Artist> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    /**working fine with MERGE , DETACH , REFRESH , REMOVE*/
    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonIgnore
    @JoinTable(name = "SONG_ARTISTS", joinColumns = {@JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SONG_ID", referencedColumnName = "ID")})
    private Song song;

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

    public Song getSong() {
        return song;
    }

    public void setSong(Song songs) {
        this.song = songs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", songs=" + song +
                '}';
    }
}
