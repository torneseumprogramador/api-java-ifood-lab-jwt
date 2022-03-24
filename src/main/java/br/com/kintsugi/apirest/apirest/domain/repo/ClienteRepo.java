package br.com.kintsugi.apirest.apirest.domain.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.kintsugi.apirest.apirest.domain.entidade.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
  
}
