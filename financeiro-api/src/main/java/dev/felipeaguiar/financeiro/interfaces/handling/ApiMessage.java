package dev.felipeaguiar.financeiro.interfaces.handling;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiMessage {

	private final String code;
	private final String message;

}
