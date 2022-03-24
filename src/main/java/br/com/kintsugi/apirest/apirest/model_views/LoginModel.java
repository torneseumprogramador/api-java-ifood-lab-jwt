package br.com.kintsugi.apirest.apirest.model_views;

public class LoginModel {
  private String email;
  private String senha;

  public String getEmail() {
    return email;
  }
  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}
