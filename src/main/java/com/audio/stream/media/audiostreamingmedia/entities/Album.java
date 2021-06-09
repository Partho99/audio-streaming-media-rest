package com.audio.stream.media.audiostreamingmedia.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ALBUM")
public class Album extends AuditableEntity<Album> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @OneToMany
    @JoinTable(name = "ALBUM_LABELS", joinColumns = {@JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "LABEL_ID", referencedColumnName = "ID")})
    private Set<Label> labels;

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

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }
}
