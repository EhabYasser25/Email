package com.example.Email_Back.Email;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashMap;

public class EmailHandler {

    private String directory = "database\\Emails\\";
    private String fileName = "emails";
    private String extension = ".json";

    public void saveEmails(HashMap<String, Email> emails) {
        try (FileOutputStream myFile = new FileOutputStream(this.directory + this.fileName + this.extension)) {
            ObjectMapper mapper = new ObjectMapper();
            byte[] Obj = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(emails);
            myFile.write(Obj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Save Done");
    }

    public HashMap<String, Email> loadEmails() {
        HashMap<String, Email> emails;
        try (FileReader myFile = new FileReader(this.directory + this.fileName + this.extension)) {
            ObjectMapper mapper = new ObjectMapper();
            emails = mapper.readValue(myFile, new TypeReference<HashMap<String, Email>>() {});
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        for (HashMap.Entry<String, Email> set : emails.entrySet())
            System.out.println(set.getValue().getSender());
        return emails;
    }
}