package com.api.finaceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.finaceiro.domain.Saida;
import com.api.finaceiro.domain.Usuario;
import com.api.finaceiro.repositories.SaidaRepository;
import com.api.finaceiro.service.exceptions.ObjectNotFoundException;

@Service
public class SaidaService {
	
	@Autowired
	private SaidaRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	public Saida findById(Integer id) {
		Optional<Saida> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Saida não encontrada! id: " +id+",Tipo: "+Saida.class.getName()));

	}

	public List<Saida> findAll(Integer id_usu) {
		usuarioService.findById(id_usu);
		return repository.findAllByUsuario(id_usu);

	}

	public Saida update(Integer id, Saida obj) {
		Saida newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Saida newObj, Saida obj) {
		newObj.setValor(obj.getValor());
		newObj.setData(obj.getData());
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipo(obj.getTipo());
		newObj.setStatus(obj.getStatus());
		
		
	}

	public Saida create(Integer id_usu, Saida obj) {
		obj.setId(null);
		Usuario usu = usuarioService.findById(id_usu);
		obj.setUsuario(usu);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Saida obj = findById(id);
		repository.delete(obj);
		
	}

}
