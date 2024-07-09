package com.webServiceCR7Imports.webServiceCR7.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webServiceCR7Imports.webServiceCR7.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.userName =:userName")
	public Usuario findByUsername(@Param("userName") String userName);

	
}
