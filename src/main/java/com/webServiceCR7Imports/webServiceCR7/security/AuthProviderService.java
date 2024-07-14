package com.webServiceCR7Imports.webServiceCR7.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.webServiceCR7Imports.webServiceCR7.config.FeignConfig;
import com.webServiceCR7Imports.webServiceCR7.dto.AcessRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Acess;
import com.webServiceCR7Imports.webServiceCR7.repository.AcessRepository;

import feign.FeignException;



@Component
public class AuthProviderService implements AuthenticationProvider {
    
    @Autowired
    private AcessRepository acessRepository;
    
    @Autowired
    private FeignConfig feignConfig;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String login = auth.getName();
        String senha = auth.getCredentials().toString();


        Acess acess = new Acess();
        
        try {
        	acess = acessRepository.login(new AcessRequest(login, senha));
        } catch (FeignException e) {
            if (e.status() == 403) {
            	throw new BadCredentialsException(e.getMessage());
            }
        }

		if (acess != null) {
			feignConfig.setToken(acess.getToken());
			return new TokenAuthentication(acess.getToken(), true, login);
		}
		throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
	}

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

}
