package Email;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class EmailService {

    private EmailDB database;

    public EmailService(EmailDB db){
        this.database = db;
    }

    @GetMapping("email/inbox")
    public ResponseEntity<EmailHeader[]> retrieveInbox(String userEmail){
        String[] userEmailsIDS = {"1", "2", "3"}; //access user received ids
        EmailHeader[] headers = new EmailHeader[userEmailsIDS.length];
        for (int i = 0; i < userEmailsIDS.length; i++)
            headers[i] = database.retrieveEmail(userEmailsIDS[i]).createHeader();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @GetMapping("email/sent")
    public ResponseEntity<EmailHeader[]> retrieveSent(String userEmail){
        String[] userEmailsIDS = {"1", "2", "3"}; //access user sent ids
        EmailHeader[] headers = new EmailHeader[userEmailsIDS.length];
        for (int i = 0; i < userEmailsIDS.length; i++)
            headers[i] = database.retrieveEmail(userEmailsIDS[i]).createHeader();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @GetMapping("email/trashed")
    public ResponseEntity<EmailHeader[]> retrieveTrashed(String userEmail){
        String[] userEmailsIDS = {"1", "2", "3"}; //access user trashed ids
        EmailHeader[] headers = new EmailHeader[userEmailsIDS.length];
        for (int i = 0; i < userEmailsIDS.length; i++)
            headers[i] = database.retrieveEmail(userEmailsIDS[i]).createHeader();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

}
