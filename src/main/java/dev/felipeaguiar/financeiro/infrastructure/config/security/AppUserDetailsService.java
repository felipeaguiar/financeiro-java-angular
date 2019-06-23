package dev.felipeaguiar.financeiro.infrastructure.config.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.felipeaguiar.financeiro.domain.usuario.Usuario;
import dev.felipeaguiar.financeiro.domain.usuario.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));

		return new User(email, usuario.getSenha(), getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		return usuario.getPerfis().stream()
			.flatMap(p -> p.getPermissoes().stream())
			.map(p -> new SimpleGrantedAuthority(p.getDescricao()))
			.collect(Collectors.toSet());
	}

}
