package com.api.finaceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.finaceiro.domain.Entrada;
import com.api.finaceiro.domain.Usuario;
import com.api.finaceiro.repositories.EntradaRepository;
import com.api.finaceiro.service.exceptions.ObjectNotFoundException;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	public Entrada findById(Integer id) {
		Optional<Entrada> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Entrada não encontrada! id: " +id+",Tipo: "+Entrada.class.getName()));

	}

	public List<Entrada> findAll(Integer id_usu) {
		usuarioService.findById(id_usu);
		return repository.findAllByUsuario(id_usu);

	}

	public Entrada update(Integer id, Entrada obj) {
		Entrada newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Entrada newObj, Entrada obj) {
		newObj.setValor(obj.getValor());
		newObj.setData(obj.getData());
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipo(obj.getTipo());
		newObj.setStatus(obj.getStatus());
		
		
	}

	public Entrada create(Integer id_usu, Entrada obj) {
		obj.setId(null);
		Usuario usu = usuarioService.findById(id_usu);
		obj.setUsuario(usu);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Entrada obj = findById(id);
		repository.delete(obj);
		
	}
}
