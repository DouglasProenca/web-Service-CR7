package com.webServiceCR7Imports.webServiceCR7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.webServiceCR7Imports.webServiceCR7.security.CustomAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebConfig {

	@SuppressWarnings("deprecation")
	@Configuration
	@EnableWebSecurity
	@Order(1)
	public class FuncConfigAdapter extends WebSecurityConfigurerAdapter{
		
		
		@Autowired
		private CustomAuthenticationFailureHandler authFailHandler;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {

            http
                    .csrf(csrf -> csrf.disable())
                    .antMatcher("/admin/**").authorizeRequests(requests -> requests
                    .antMatchers("/admin/login", "/admin/**", "/produto/**", "/usuario/**").authenticated()
                    .antMatchers("/home", "/**", "/logout","/assets/**", "/assets/img/**" , "/assets/css/**").permitAll())
                    .formLogin(form -> form.loginPage("/admin/login").loginProcessingUrl("/admin/login")
                                    .defaultSuccessUrl("/admin", true)
                                    .failureHandler(authFailHandler).permitAll()
                    ).logout(logout -> logout
                            .logoutUrl("/admin/logout")
                            .logoutSuccessUrl("/admin/login")
                            .permitAll()).csrf(csrf -> csrf.disable());
		}		
		
	}
	
	@Configuration
	@EnableWebSecurity
	@Order(2)
	public class CommonConfigAdapter extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/**").authorizeRequests()
			.antMatchers("/home", "/**", "/logout","/assets/**", "/assets/img/**" , "/assets/css/**").permitAll().and().csrf().disable();
		}
	}
}
