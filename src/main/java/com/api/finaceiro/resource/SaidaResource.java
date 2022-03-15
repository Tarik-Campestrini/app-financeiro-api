package com.api.finaceiro.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.finaceiro.domain.Saida;
import com.api.finaceiro.dtos.SaidaDTO;
import com.api.finaceiro.service.SaidaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/saida")
public class SaidaResource {

	@Autowired
	private SaidaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Saida> findById(@PathVariable Integer id) {
		Saida obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<SaidaDTO>> findAll(@RequestParam(value = "usuario", defaultValue = "0") Integer id_usu) {
		List<Saida> list = service.findAll(id_usu);
		List<SaidaDTO> listDTO = list.stream().map(obj -> new SaidaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Saida> create(@RequestParam(value = "usuario", defaultValue = "0") Integer id_usu,
			@Valid @RequestBody Saida obj) {
		Saida newObj = service.create(id_usu, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/saida/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Saida> update(@PathVariable Integer id, @Valid @RequestBody Saida obj) {
		Saida newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Saida> updatePatch(@PathVariable Integer id, @Valid @RequestBody Saida obj) {
		Saida newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
