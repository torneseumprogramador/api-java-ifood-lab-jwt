package br.com.kintsugi.apirest.apirest.model_views;

public class AdministradorToken {
  public AdministradorToken(){}
  public String getErro() {
    return erro;
  }
  public void setErro(String erro) {
    this.erro = erro;
  }
  public AdministradorToken(int id, String nome, String email, String token){
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.token = token;
  }
  private int id;
  private String nome;
  private String email;
  private String token;
  private String erro;
  public int getId() {
    return id;
  }
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
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
  public void setId(int id) {
    this.id = id;
  }
  
}
