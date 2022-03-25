package br.com.kintsugi.apirest.apirest.domain.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "nome", length = 100, nullable = false)
  private String nome;
  private String email;
  private String senha;

  public int getId() {
    return id;
  }
  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<String> permissoes(){
    List<String> permissoes = new ArrayList<String>();
    permissoes.add("ADMIN");
    permissoes.add("EDITOR");
    return permissoes;
  }
}
