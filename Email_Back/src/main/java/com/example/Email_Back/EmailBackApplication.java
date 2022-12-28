package com.example.Email_Back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import javax.swing.plaf.basic.BasicFileChooserUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@SpringBootApplication
public class EmailBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmailBackApplication.class, args);
	}

}
