package hu.jusoft.gerevet.repository.model;

/**
 * Created by Regina Seres on 1/3/2016.
 */
public class ExaminationFile {
    private String name;
    private String contentType;
    private byte[] file;

    public ExaminationFile(String name, String contentType, byte[] file) {
        this.name = name;
        this.contentType = contentType;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getFile() {
        return file;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
