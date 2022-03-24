package br.com.kintsugi.apirest.apirest.domain.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.kintsugi.apirest.apirest.domain.entidade.Administrador;

public interface AdministradorRepo extends CrudRepository<Administrador, Integer> {
  
  @Query(value="select * from administradores where email = :email", nativeQuery = true)
  public Administrador findByEmail(String email);
}
