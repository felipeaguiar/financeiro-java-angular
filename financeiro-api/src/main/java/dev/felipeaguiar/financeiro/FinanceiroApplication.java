package dev.felipeaguiar.financeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.felipeaguiar.financeiro.infrastructure.config.AppProperty;

@SpringBootApplication
@EnableConfigurationProperties(AppProperty.class)
public class FinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}

}
