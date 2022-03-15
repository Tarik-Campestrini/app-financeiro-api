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

import com.api.finaceiro.domain.Entrada;
import com.api.finaceiro.dtos.EntradaDTO;
import com.api.finaceiro.service.EntradaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/entrada")
public class EntradaResource {

	@Autowired
	private EntradaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrada> findById(@PathVariable Integer id) {
		Entrada obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<EntradaDTO>> findAll(
			@RequestParam(value = "usuario", defaultValue = "0") Integer id_usu) {
		List<Entrada> list = service.findAll(id_usu);
		List<EntradaDTO> listDTO = list.stream().map(obj -> new EntradaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Entrada> create(@RequestParam(value = "usuario", defaultValue = "0") Integer id_usu,
			@Valid @RequestBody Entrada obj) {
		Entrada newObj = service.create(id_usu, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/entrada/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Entrada> update(@PathVariable Integer id, @Valid @RequestBody Entrada obj) {
		Entrada newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Entrada> updatePatch(@PathVariable Integer id, @Valid @RequestBody Entrada obj) {
		Entrada newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
