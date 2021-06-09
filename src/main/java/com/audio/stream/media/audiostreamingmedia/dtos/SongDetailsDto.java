package com.audio.stream.media.audiostreamingmedia.dtos;


import com.audio.stream.media.audiostreamingmedia.entities.Album;
import com.audio.stream.media.audiostreamingmedia.entities.Artist;
import com.audio.stream.media.audiostreamingmedia.entities.Band;
import com.audio.stream.media.audiostreamingmedia.entities.Movie;

import java.util.Date;
import java.util.List;

public class SongDetailsDto {

    private Long id;
    private String name;
    private Date releaseDate;
    private String url;
    private String imageUrl;
    private String slug;
    private Boolean activeStatus;

    private List<Artist> artists;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

}
