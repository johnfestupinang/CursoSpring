package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bolsadeideas.springboot.app.auth.handler.LoginSuccesHandler;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccesHandler successHandler;
	@Bean
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	//Autorizacion http
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar").permitAll()
//			.antMatchers("/ver/**").hasAnyRole("USER")
//			.antMatchers("/uploads/**").hasAnyRole("USER")
//			.antMatchers("/form/**").hasAnyRole("ADMIN")
//			.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
//			.antMatchers("/factura/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().successHandler(successHandler)
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/error_403");
			
		}
	
	//Autenticacion
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		PasswordEncoder encoder = passwordEnconder(); //Forma en la cual se va a encriptar la contraseña formato BCrypt
		UserBuilder users = User.builder().passwordEncoder(encoder::encode); //Simplificando el codigo usando expresion lamda
		
		builder.inMemoryAuthentication()//Configurar el builder en memoria y confiuramos los usuarios
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));
		
	}

	
	
	
	
}
