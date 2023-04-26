package br.com.netoware.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netoware.loja.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
