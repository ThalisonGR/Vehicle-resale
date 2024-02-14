package br.com.revenda;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RevendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevendaApplication.class, args);
	}

}
