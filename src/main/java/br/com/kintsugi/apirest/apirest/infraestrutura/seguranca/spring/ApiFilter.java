package br.com.kintsugi.apirest.apirest.infraestrutura.seguranca.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

// import br.com.isidrocorp.ecommerce.security.TokenUtil;

public class ApiFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getRequestURI().substring(request.getContextPath().length());

		// if (request.getHeader("Authorization") != null && !path.equals("/login")) {
		// 	Authentication auth = TokenUtil.validate(request);   // verifico se é válida
		// 	// se for válida, insiro um cabeçalho do tipo Authentication indicando que a requisição é autenticada
		// 	SecurityContextHolder.getContext().setAuthentication(auth);			
		// }
		
		filterChain.doFilter(request, response);		
	}
}
