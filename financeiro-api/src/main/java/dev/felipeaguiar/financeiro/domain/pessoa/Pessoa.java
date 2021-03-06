package dev.felipeaguiar.financeiro.domain.pessoa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.apache.commons.lang3.BooleanUtils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Version
	@Getter
	private Long version;

	@Column(length = 50, nullable = false)
	@NonNull
	@Getter @Setter
	private String nome;

	@Column(nullable = false)
	@NonNull
	@Getter @Setter
	private Boolean ativo;

	@Embedded
	@Getter @Setter
	private Endereco endereco;

	public boolean isInativo() {
		return BooleanUtils.isFalse(ativo);
	}

}
