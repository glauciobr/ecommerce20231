package br.com.netoware.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netoware.loja.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
