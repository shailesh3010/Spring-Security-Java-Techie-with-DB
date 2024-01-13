package com.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
			
//		UserDetails normalUser = org.springframework.security.core.userdetails.User
//										.withUsername("shailesh")
//										.password(passwordEncoder().encode("shailesh"))
//										.roles("NORMAL")
//										.build();
//		
//		UserDetails adminUser = org.springframework.security.core.userdetails.User
//								.withUsername("Mukesh")
//								.password(passwordEncoder().encode("mukesh"))
//								.roles("ADMIN")
//								.build();
//		
//		InMemoryUserDetailsManager inMemoryUserDetailsManager =new InMemoryUserDetailsManager(normalUser,adminUser);
//		
//		return inMemoryUserDetailsManager;
		
		return new UserInfoUserDetailService();
		
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		
		
//		httpSecurity.csrf().disable()
//					.authorizeHttpRequests()
//					.requestMatchers("home/normal")
//					.hasRole("NORMAL")
//					.requestMatchers("home/admin")
//					.hasRole("ADMIN")
//					.requestMatchers("home/public","home/new")
//					.permitAll()
//					.anyRequest()
//					.authenticated()
//					.and()
//					.formLogin();
		
		httpSecurity.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("home/public","home/new")
					.permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("home/admin","home/normal")
					.authenticated()
					.and()
					.formLogin();
					
					
		
		return httpSecurity.build();
		
		
		
	}
	
	
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService());
//		authenticationProvider.setPasswordEncoder(passwordEncoder());
//		return authenticationProvider();
//	}

}
