package br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.jwt;

public class Token {
	private String token;
	
	public Token(String token) {
		super();
		this.token = token;
	}
	
	public Token() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
