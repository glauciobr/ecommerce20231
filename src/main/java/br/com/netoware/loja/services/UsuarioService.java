package br.com.netoware.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netoware.loja.domain.Usuario;
import br.com.netoware.loja.repository.EnderecoRepository;
import br.com.netoware.loja.repository.UsuarioRepository;
import br.com.netoware.loja.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Usuario> obterTodosUsuarios() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}
	
	public Usuario obterUsuario(Long id) {
		
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		
		if (usuario == null) {
			throw new UsuarioNaoEncontradoException();
		}
		
		return usuario;
	}
}
