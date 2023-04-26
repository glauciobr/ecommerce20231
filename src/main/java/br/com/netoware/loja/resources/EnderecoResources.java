package br.com.netoware.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.netoware.loja.domain.Endereco;
import br.com.netoware.loja.domain.Usuario;
import br.com.netoware.loja.repository.EnderecoRepository;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResources {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String cadastrarEndereco(@RequestBody Endereco endereco, @PathVariable("id") Long idUsuario) {
		
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		
		endereco.setUsuario(usuario);
		
		Endereco end = enderecoRepository.save(endereco);
		
		return "Endereço cadastrado com sucesso";
	}

}
