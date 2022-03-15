package com.api.finaceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.finaceiro.domain.Usuario;
import com.api.finaceiro.repositories.UsuarioRepository;
import com.api.finaceiro.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! id: "+id+ ", Tipo" + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario create(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());		
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.api.finaceiro.service.exceptions.DataIntegrityViolationException("Usuário não pode ser excluido! Possui entrada e saida associados");
		}
		
	}

}
