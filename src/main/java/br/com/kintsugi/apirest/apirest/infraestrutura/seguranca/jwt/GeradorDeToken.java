package br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.jwt;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.kintsugi.apirest.apirest.domain.entidade.Administrador;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class GeradorDeToken {
	// puro preciosismo para clean code
	private static final int    SEGUNDOS = 1000;
	private static final int    MINUTOS  = 60*SEGUNDOS;
	
	private static final String HEADER = "Authorization";  // cabecalho http
	private static final String PREFIX = "Bearer ";        // prefixo do token
	private static final long   EXPIRATION = 5*MINUTOS;    // tempo de validade
	private static final String SECRET_KEY = "3c0MMerc3Do1f00dP@r@T3st3sD3JWT*";  // palavra chave do token
	private static final String EMISSOR    = "ProfIsidroIfood";
	
	
	public static String criarToken(Administrador adm) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder().setSubject(adm.getEmail())
								     .setIssuer(EMISSOR)
								     .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
								     .signWith(secretKey, SignatureAlgorithm.HS256)
								     .compact();
		return PREFIX + token;
	}
	
	/* posso criar métodos auxiliares para ajudar na validação */
	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));	// a expiração para ser válida tem que ser após a data atual	
	}
	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}
	private static boolean isSubjectValid(String email) {
		return email!=null && email.length() > 0;
	}
	
	public static Authentication validarRequest(HttpServletRequest request) {

		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, "");
		
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
				                                    .build()
				                                    .parseClaimsJws(token);
		
		String email = jwsClaims.getBody().getSubject();
		String issuer   = jwsClaims.getBody().getIssuer();
		Date   expira   = jwsClaims.getBody().getExpiration();
		
		if (isSubjectValid(email) && isEmissorValid(issuer) && isExpirationValid(expira)) {
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		}
	
		return null; 
	}

}
