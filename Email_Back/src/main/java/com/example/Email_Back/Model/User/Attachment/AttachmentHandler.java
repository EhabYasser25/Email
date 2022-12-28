package com.example.Email_Back.Model.User.Attachment;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AttachmentHandler {

    private String directory = "database\\Attachments\\";
    private String fileName;
    private String extension;
    private byte[] BytesOfAttachment;

    public void LoadAttachment(Attachment ourAttachment) {
        String filePath = ourAttachment.getPath();
        fileName = ourAttachment.getName();
        extension = ourAttachment.getExtension();
        try(FileInputStream fin = new FileInputStream(filePath + fileName + extension)) {//TODO handle extension
            BytesOfAttachment = fin.readAllBytes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void SaveToDB (String id) {
        try(FileOutputStream fos = new FileOutputStream(directory + id + extension)) {//TODO handle extension
            fos.write(BytesOfAttachment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
