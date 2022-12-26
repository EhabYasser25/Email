package Email;

public class Email {

    private final String id;
    private final String emailBody;
    private final int date;
    private final String sender;
    private final String receiver;
    private final String subject;
    private final String attachments_URL;

    private boolean read;

    public Email(Email email){
        this.id = RandomGenerator.generateId();
        this.emailBody = email.emailBody;
        this.date = email.date;
        this.sender = email.sender;
        this.receiver = email.receiver;
        this.subject = email.subject;
        this.attachments_URL = email.attachments_URL;
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

    public String getAttachments_URL() {
        return attachments_URL;
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
