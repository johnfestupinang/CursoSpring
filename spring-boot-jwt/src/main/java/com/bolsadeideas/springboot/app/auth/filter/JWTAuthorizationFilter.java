package com.bolsadeideas.springboot.app.auth.filter;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.bolsadeideas.springboot.app.auth.service.IJWTService;
import com.bolsadeideas.springboot.app.auth.service.JwtServiceImpl;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private IJWTService jwtService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, IJWTService jwtService) {
		super(authenticationManager);
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

	
		String header = request.getHeader(JwtServiceImpl.HEADER_STRING);
		if (!requiresAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}
				
		UsernamePasswordAuthenticationToken authentication = null;
		
		if(jwtService.validate(header)){ //El header es el token

			
	
			//Collection<? extends GrantedAuthority> authorities = (new ObjectMapper().readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class)).;
			
			authentication = new UsernamePasswordAuthenticationToken(jwtService.getUsername(header), null,   jwtService.getRoles(header));
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);//Maneja el contexto de seguridad, asignar el objeto authentication dentro del contexto, autentica el usuario dentro del request
		chain.doFilter(request, response);
	}

	protected boolean requiresAuthentication(String header) {
		if (header == null || !header.startsWith(JwtServiceImpl.TOKEN_PREFIX)) {
			return false;
		}
		return true;
	}

}
