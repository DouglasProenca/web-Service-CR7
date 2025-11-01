package com.webServiceCR7Imports.webServiceCR7.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.webServiceCR7Imports.webServiceCR7.config.FeignConfig;
import com.webServiceCR7Imports.webServiceCR7.model.request.AcessRequest;
import com.webServiceCR7Imports.webServiceCR7.model.response.AcessResponse;
import com.webServiceCR7Imports.webServiceCR7.service.AcessService;

import feign.FeignException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AuthProviderService implements AuthenticationProvider {

	private final AcessService acessService;
	private final FeignConfig feignConfig;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		try {
		AcessResponse acess = acessService.login(new AcessRequest(auth.getName(), auth.getCredentials().toString()));

		feignConfig.setToken(acess.getToken());
		
        return new TokenAuthentication(acess.getToken(), true, acess.getUsername());
        
		} catch (FeignException e) {
			if (e.status() == 403) {
				throw new BadCredentialsException(e.getMessage());	
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
