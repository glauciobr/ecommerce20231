package br.com.netoware.loja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.netoware.loja.domain.Endereco;
import br.com.netoware.loja.domain.Usuario;
import br.com.netoware.loja.repository.EnderecoRepository;
import br.com.netoware.loja.repository.UsuarioRepository;
import br.com.netoware.loja.services.UsuarioService;
import br.com.netoware.loja.services.exceptions.UsuarioNaoEncontradoException;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService usuarioService;	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> obterTodosUsuarios() {
		
		return usuarioService.obterTodosUsuarios();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> obterUsuario(@PathVariable("id") Long id) {
		
		Usuario usuario = usuarioService.obterUsuario(id);	
		 
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		
		Usuario u = usuarioRepository.findById(id).orElse(null);
		if (u == null) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioRepository.delete(u);
		
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario ) {
		
		usuarioRepository.save(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(@RequestBody Usuario usuario) {
		
		Usuario u = usuarioRepository.save(usuario);
		
		
		for (Endereco endereco : usuario.getEnderecos()) {
			endereco.setUsuario(u);
			enderecoRepository.save(endereco);
		}
		
		return "Usuario cadastrado com sucesso";
	}
	
}
