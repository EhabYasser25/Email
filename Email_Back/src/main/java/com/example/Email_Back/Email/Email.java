package com.example.Email_Back.Email;

import com.example.Email_Back.Utils.RandomGenerator;

public class Email {

    private String id;
    private String emailBody;
    private int date;
    private String sender;
    private String receiver;
    private String subject;
    private String[] attachments_IDS;

    private boolean read;

    public void setEmailProperties(Email email) {
        this.id = RandomGenerator.generateId();
        this.emailBody = email.emailBody;
        this.date = email.date;
        this.sender = email.sender;
        this.receiver = email.receiver;
        this.subject = email.subject;
        this.attachments_IDS = email.attachments_IDS;
        this.read = false;
    }

    public void setEmailProperties(String id, String emailBody, int date, String sender, String receiver, String subject, String[] attachments_IDS) {
        this.id = id;
        this.emailBody = emailBody;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.attachments_IDS = attachments_IDS;
        this.read = false;
    }

    public String getId() {
        return id;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public int getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String[] getAttachments_IDS() {
        return attachments_IDS;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead() {
        this.read = true;
    }

    public EmailHeader createHeader(){
        if(this.emailBody.length() < 50)
            return new EmailHeader(this.emailBody, this.sender, this.subject, this.date, this.read);
        return new EmailHeader(this.emailBody.substring(0,50), this.sender, this.subject, this.date, this.read);
    }
}
