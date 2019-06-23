package dev.felipeaguiar.financeiro.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;

@ConfigurationProperties("app")
public class AppProperty {

	@Getter
	private final Seguranca seguranca = new Seguranca();

	@Data
	public static class Seguranca {
		private String corsOrigin = "*";
	}
}
