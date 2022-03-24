package br.com.kintsugi.apirest.apirest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kintsugi.apirest.apirest.domain.entidade.Administrador;
import br.com.kintsugi.apirest.apirest.domain.repo.AdministradorRepo;
import br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.cripto.Criptografia;
import br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.jwt.GeradorDeToken;
import br.com.kintsugi.apirest.apirest.model_views.AdministradorToken;
import br.com.kintsugi.apirest.apirest.model_views.LoginModel;

@CrossOrigin("*")
@RestController
public class LoginController {

  @Autowired
  private AdministradorRepo repo;

  @PostMapping("/login")
  public ResponseEntity<AdministradorToken> login(@RequestBody LoginModel login) throws Exception{
    Administrador adm = (Administrador)repo.findByEmail(login.getEmail());
    if(adm == null){
      AdministradorToken admToken = new AdministradorToken();
      admToken.setErro("Administrador não cadastrado");
      return ResponseEntity.status(401).body(admToken);
    }
    else{
      String senhaCripto = Criptografia.gerar(login.getSenha());
      if(!adm.getSenha().equals(senhaCripto)){
        AdministradorToken admToken = new AdministradorToken();
        admToken.setErro("Email ou senha inválidos");
        return ResponseEntity.status(401).body(admToken);
      }
    }

    String token = GeradorDeToken.criarToken(adm);
    AdministradorToken admToken = new AdministradorToken(adm.getId(), adm.getNome(), adm.getEmail(), token);
    return ResponseEntity.ok(admToken);
  }
}
