package com.webServiceCR7Imports.webServiceCR7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webServiceCR7Imports.webServiceCR7.exception.RegraNegocioException;
import com.webServiceCR7Imports.webServiceCR7.model.Usuario;



@Service
public class UsuarioService {

	//@Autowired
	//private UsuarioRepository usuarioRepo;
	
	public Usuario salvar(Usuario usuario) {
	
		Usuario usuarioExistente = new Usuario();//usuarioRepo.findByUsername(usuario.getUserName());
		
		if(usuarioExistente != null && usuarioExistente.equals(usuario)) {
			throw new RegraNegocioException("Já existe um usuario cadastrado com este e-mail.");
		}
			
		//return usuarioRepo.save(usuario);
		return null;
	}
	
	public Usuario findByEmail(String email) {
		//return usuarioRepo.findByUsername(email);
		return new Usuario();
	}
	
	public List<Usuario> findAll() {
		//return usuarioRepo.findAll();
		return null;
	}
	
	public Usuario findOne(int idUsuario) {
		//return usuarioRepo.findById(idUsuario)
		//		.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
		return null;
	}	
		
	
	public void delete(int id) {
		//this.usuarioRepo.deleteById(id);
	}

	// deletar VARAIOS
	public void deleteMany(int[] ids) {
		//for (int i : ids) {
		//	this.usuarioRepo.deleteById(i);
		//}		
	}
	
	
	public Usuario update(int idUsuario, Usuario updateUsuario) {
		/*Optional<Usuario> usuarioOptional = this.usuarioRepo.findById(idUsuario);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setId(updateUsuario.getId());
			usuarioExistente.set(updateUsuario.getUsername());
			usuarioExistente.setCPF(updateUsuario.getCPF());
			usuarioExistente.setDataNascimento(updateUsuario.getDataNascimento());
			usuarioExistente.setEmail(updateUsuario.getEmail());
			usuarioExistente.setIsAtivo(updateUsuario.getIsAtivo());
			if(updateUsuario.getSenha() != null && !updateUsuario.getSenha().trim().isEmpty()) {
				usuarioExistente.setSenha(updateUsuario.getSenha());
			}
			usuarioExistente.setTelefone(updateUsuario.getTelefone());
			usuarioExistente.setTipo(updateUsuario.getTipo());
					

			return this.usuarioRepo.save(usuarioExistente);
		} else {
			throw new RuntimeException("Usuario(a) nao encontrado(a)");
		}*/
		return null;
	}
	
}
