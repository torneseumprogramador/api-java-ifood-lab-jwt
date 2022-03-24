package br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.spring;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.jwt.GeradorDeToken;

public class ApiFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getRequestURI().substring(request.getContextPath().length());

		if (request.getHeader("Authorization") != null && !path.equals("/login")) {
			Authentication auth = GeradorDeToken.validarRequest(request);  
			SecurityContextHolder.getContext().setAuthentication(auth);			
		}
		
		filterChain.doFilter(request, response);		
	}
}
