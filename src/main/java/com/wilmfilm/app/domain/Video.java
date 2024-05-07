package com.wilmfilm.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Video.
 */
@Entity
@Table(name = "video")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "url", nullable = false)
    private byte[] url;

    @NotNull
    @Column(name = "url_content_type", nullable = false)
    private String urlContentType;

    @JsonIgnoreProperties(value = { "video" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private VideoMetaData metaData;

    @ManyToOne(fetch = FetchType.LAZY)
    private User uploader;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Video id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getUrl() {
        return this.url;
    }

    public Video url(byte[] url) {
        this.setUrl(url);
        return this;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public String getUrlContentType() {
        return this.urlContentType;
    }

    public Video urlContentType(String urlContentType) {
        this.urlContentType = urlContentType;
        return this;
    }

    public void setUrlContentType(String urlContentType) {
        this.urlContentType = urlContentType;
    }

    public VideoMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(VideoMetaData videoMetaData) {
        this.metaData = videoMetaData;
    }

    public Video metaData(VideoMetaData videoMetaData) {
        this.setMetaData(videoMetaData);
        return this;
    }

    public User getUploader() {
        return this.uploader;
    }

    public void setUploader(User user) {
        this.uploader = user;
    }

    public Video uploader(User user) {
        this.setUploader(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Video)) {
            return false;
        }
        return getId() != null && getId().equals(((Video) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Video{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", urlContentType='" + getUrlContentType() + "'" +
            "}";
    }
}
