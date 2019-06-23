package dev.felipeaguiar.financeiro.infrastructure.config.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import dev.felipeaguiar.financeiro.domain.usuario.Usuario;

public class AppUser extends User {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public AppUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
