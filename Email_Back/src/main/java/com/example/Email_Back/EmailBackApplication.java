package com.example.Email_Back;
<<<<<<< Updated upstream

=======
import com.example.Email_Back.Model.Caches.EmailCache;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> Stashed changes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailBackApplication {

<<<<<<< Updated upstream
	public static void main(String[] args) {
		SpringApplication.run(EmailBackApplication.class, args);
=======
	@Autowired
	private EmailCache emailCache;


	public static void main(String[] args) {SpringApplication.run(EmailBackApplication.class, args);}




	@PreDestroy
	public void destroy() {
		System.out.println("Closing session\nSaving Emails...");
		this.emailCache.saveDBContents();
>>>>>>> Stashed changes
	}

}
