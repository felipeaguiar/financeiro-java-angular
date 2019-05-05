package dev.felipeaguiar.financeiro.domain.usuario;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Usuario {

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

	@Column(length = 50, nullable = false)
	@NonNull
	@Getter @Setter
	private String email;

	@Column(length = 150, nullable = false)
	@NonNull
	@Getter @Setter
	private String senha;

	@ManyToMany
	@JoinTable(name = "perfil_usuario", joinColumns = @JoinColumn(name = "id_perfil") , inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private Set<Perfil> perfis = new HashSet<>();

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil);
	}

	public void removePerfil(Perfil perfil) {
		perfis.remove(perfil);
	}

	public Set<Perfil> getPerfis() {
		return Collections.unmodifiableSet(perfis);
	}

}
