package br.com.netoware.loja.services.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
	
	public UsuarioNaoEncontradoException() {
		super("O id informado não corresponde a um usuário.");
	}

}
