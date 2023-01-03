package com.example.Email_Back;

import com.example.Email_Back.Model.Caches.EmailCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class EmailBackApplication {

	@Autowired
	private EmailCache emailCache;



	public static void main(String[] args) {
		SpringApplication.run(EmailBackApplication.class, args);
	}

}