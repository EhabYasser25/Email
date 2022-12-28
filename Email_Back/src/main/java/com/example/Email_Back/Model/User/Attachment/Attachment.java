package com.example.Email_Back.Model.User.Attachment;
import com.example.Email_Back.Utils.RandomGenerator;

public class Attachment {
    private String id;
    private String path;
    private String name;
    private String extension;

    public Attachment() {
        this.id = RandomGenerator.generateId();
    }

    //Getters & Setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getExtension() { return extension; }

    public void setExtension(String extension) { this.extension = extension; }
}
