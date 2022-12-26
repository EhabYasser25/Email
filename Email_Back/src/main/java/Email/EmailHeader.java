package Email;

public class EmailHeader {

    private final String headerBody;
    private final String sender;
    private final String subject;
    private final int date;
    private final boolean read;

    public EmailHeader(String headerBody, String sender, String subject, int date, boolean read) {
        this.headerBody = headerBody;
        this.sender = sender;
        this.subject = subject;
        this.date = date;
        this.read = read;
    }
}
