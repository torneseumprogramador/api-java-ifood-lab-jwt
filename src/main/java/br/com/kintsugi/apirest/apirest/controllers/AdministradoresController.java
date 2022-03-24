package br.com.kintsugi.apirest.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kintsugi.apirest.apirest.domain.entidade.Administrador;
import br.com.kintsugi.apirest.apirest.domain.repo.AdministradorRepo;
import br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.cripto.Criptografia;

@RestController
public class AdministradoresController {

  @Autowired
  private AdministradorRepo repo;

  @PostMapping("/administradores")
  public ResponseEntity<Administrador> create(@RequestBody Administrador adm) throws Exception{
    String senhaCripto = Criptografia.gerar(adm.getSenha());
    adm.setSenha(senhaCripto);
    repo.save(adm);
    return ResponseEntity.status(201).body(adm);
  }

  @GetMapping("/gerar-adm")
  public Administrador gerarAdm() throws Exception{
    Administrador admExistente = repo.findByEmail("danilo@gmail.com");
    if(admExistente != null) return admExistente;

    Administrador adm = new Administrador();
    adm.setEmail("danilo@gmail.com");
    adm.setNome("danilo");
    adm.setSenha("123");
    String senhaCripto = Criptografia.gerar(adm.getSenha());
    adm.setSenha(senhaCripto);
    repo.save(adm);
    
    return adm;
  }
}
