package hu.jusoft.gerevet.repository.model;

/**
 * Created by Regina Seres on 1/7/2016.
 */
public class FileData {
    private String name;
    private String id;

    public FileData(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
}
