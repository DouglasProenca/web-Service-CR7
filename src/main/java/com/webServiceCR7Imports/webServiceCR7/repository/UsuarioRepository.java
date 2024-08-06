package com.webServiceCR7Imports.webServiceCR7.repository;
import org.springframework.stereotype.Repository;

import com.webServiceCR7Imports.webServiceCR7.model.Usuario;


public interface UsuarioRepository {
	
	public Usuario findByUsername(String userName);

	
}
