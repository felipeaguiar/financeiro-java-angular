package dev.felipeaguiar.financeiro.domain.usuario;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

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
public class Perfil {

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_permissao", joinColumns = @JoinColumn(name = "id_perfil") , inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	private Set<Permissao> permissoes = new HashSet<>();

	public void addPermissao(Permissao permissao) {
		permissoes.add(permissao);
	}

	public void removePermissao(Permissao permissao) {
		permissoes.remove(permissao);
	}

	public Set<Permissao> getPermissoes() {
		return Collections.unmodifiableSet(permissoes);
	}

}
