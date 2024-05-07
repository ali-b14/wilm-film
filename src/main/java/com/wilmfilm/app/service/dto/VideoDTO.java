package com.wilmfilm.app.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.wilmfilm.app.domain.Video} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VideoDTO implements Serializable {

    private Long id;

    @Lob
    private byte[] url;

    private String urlContentType;

    private VideoMetaDataDTO metaData;

    private UserDTO uploader;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public String getUrlContentType() {
        return urlContentType;
    }

    public void setUrlContentType(String urlContentType) {
        this.urlContentType = urlContentType;
    }

    public VideoMetaDataDTO getMetaData() {
        return metaData;
    }

    public void setMetaData(VideoMetaDataDTO metaData) {
        this.metaData = metaData;
    }

    public UserDTO getUploader() {
        return uploader;
    }

    public void setUploader(UserDTO uploader) {
        this.uploader = uploader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VideoDTO)) {
            return false;
        }

        VideoDTO videoDTO = (VideoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, videoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VideoDTO{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", metaData=" + getMetaData() +
            ", uploader=" + getUploader() +
            "}";
    }
}
