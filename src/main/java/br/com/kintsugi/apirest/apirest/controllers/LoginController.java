package br.com.kintsugi.apirest.apirest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kintsugi.apirest.apirest.domain.entidade.Administrador;
import br.com.kintsugi.apirest.apirest.domain.repo.AdministradorRepo;
import br.com.kintsugi.apirest.apirest.model_views.AdministradorToken;
import br.com.kintsugi.apirest.apirest.model_views.LoginModel;

@RestController
public class LoginController {

  @Autowired
  private AdministradorRepo repo;

  @PostMapping("/login")
  public ResponseEntity<AdministradorToken> login(@RequestBody LoginModel login){
    Administrador adm = (Administrador)repo.findByEmail(login.getEmail());
    if(adm == null){
      AdministradorToken admToken = new AdministradorToken();
      admToken.setErro("Administrador não cadastrado");
      return ResponseEntity.status(401).body(admToken);
    }
    else if(!adm.getSenha().equals(login.getSenha())){
      AdministradorToken admToken = new AdministradorToken();
      admToken.setErro("Email ou senha inválidos");
      return ResponseEntity.status(401).body(admToken);
    }

    AdministradorToken admToken = new AdministradorToken(adm.getId(), adm.getNome(), adm.getEmail(), "12345432123");
    return ResponseEntity.ok(admToken);
  }
}
