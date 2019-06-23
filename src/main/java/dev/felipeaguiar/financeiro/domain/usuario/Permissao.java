package dev.felipeaguiar.financeiro.domain.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Immutable
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Permissao {

	@Id
	@Getter
	private Long id;

	@Column(length = 50, nullable = false)
	@NonNull
	@Getter
	private String descricao;

}
