package com.bolsadeideas.springboot.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bolsadeideas.springboot.app.auth.filter.JWTAuthenticationFilter;
import com.bolsadeideas.springboot.app.auth.filter.JWTAuthorizationFilter;
import com.bolsadeideas.springboot.app.auth.handler.LoginSuccesHandler;
import com.bolsadeideas.springboot.app.auth.service.IJWTService;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	@Autowired private DataSource data_source;
	
	@Autowired private JpaUserDetailsService userDetailsService;
	
	@Autowired private IJWTService jwtServie;
	

	//Autorizacion http
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar**","/locale").permitAll()
//			.antMatchers("/ver/**").hasAnyRole("USER")
//			.antMatchers("/uploads/**").hasAnyRole("USER")
//			.antMatchers("/form/**").hasAnyRole("ADMIN")
//			.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
//			.antMatchers("/factura/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			/*.and()
			.formLogin().successHandler(successHandler)
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/error_403")*/
			.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtServie))//authenticationManager() de cla clase abstratc de la cual hereda esta 
			.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtServie))//Filtro de autorizacion
			.csrf().disable()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Desactivar token csrfx
			
		}
	
	//Autenticacion
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEnconder);
		
//		builder.jdbcAuthentication().dataSource(data_source)
//		.passwordEncoder(passwordEnconder)
//		.usersByUsernameQuery("select username, password, enabled from users where username=?")
//		.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id = u.id) where u.username=?");
//		
		
		/*PasswordEncoder encoder = this.passwordEnconder; //Forma en la cual se va a encriptar la contraseña formato BCrypt
		UserBuilder users = User.builder().passwordEncoder(encoder::encode); //Simplificando el codigo usando expresion lamda
		
		builder.inMemoryAuthentication()//Configurar el builder en memoria y confiuramos los usuarios
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));*/
		
	}

	
	
	
	
}
