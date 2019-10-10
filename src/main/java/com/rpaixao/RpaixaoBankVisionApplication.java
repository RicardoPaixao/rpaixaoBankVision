package com.rpaixao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rpaixao.models.User;
import com.rpaixao.repositories.UserRepository;

@SpringBootApplication
public class RpaixaoBankVisionApplication {
	public static void main(String[] args) {
		SpringApplication.run(RpaixaoBankVisionApplication.class, args);
	}
}
