package com.petStore;

import com.petStore.jpa.entity.Pet;
import com.petStore.jpa.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@SpringBootApplication
public class PetStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}

//	@Configuration
//	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//
//			http
//					.httpBasic().and()
//					.authorizeRequests()
//					.antMatchers("/index.html","/").permitAll()
////					.anyRequest().authenticated()
//					.anyRequest().permitAll()
//					.and()
//					.csrf()
//					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		}
//
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth)
//				throws Exception {
//			auth.inMemoryAuthentication()
//					.withUser("user").password("password").roles("USER")
//					.and()
//					.withUser("admin").password("password").roles("ADMIN");
//		}
//	}


}
