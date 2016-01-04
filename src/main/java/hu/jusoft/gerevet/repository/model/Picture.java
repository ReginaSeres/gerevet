package hu.jusoft.gerevet.repository.model;

/**
 * Created by Regina Seres on 1/3/2016.
 */
public class Picture {
    private String name;
    private String contentType;
    private byte[] picture;

    public Picture(String name, String contentType, byte[] picture) {
        this.name = name;
        this.contentType = contentType;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
