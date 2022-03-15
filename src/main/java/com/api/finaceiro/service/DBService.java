package com.api.finaceiro.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.finaceiro.domain.Entrada;
import com.api.finaceiro.domain.Mes;
import com.api.finaceiro.domain.Saida;
import com.api.finaceiro.domain.Usuario;
import com.api.finaceiro.repositories.EntradaRepository;
import com.api.finaceiro.repositories.MesRepository;
import com.api.finaceiro.repositories.SaidaRepository;
import com.api.finaceiro.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EntradaRepository entradaRepository;
	@Autowired
	private SaidaRepository saidaRepository;
	@Autowired
	private MesRepository mesRepository;

	public void instanciaBaseDeDados() {

		Usuario usu1 = new Usuario(null, "Tarik", "Campestrini", "tarikrc@hotmail.com", "123");
		
		Mes mes1 = new Mes(null, "Janeiro");

		Entrada ent = new Entrada(null, "1250", "2022-10-10", "Salario", "Pix", "Recebido", usu1, mes1);

		Saida sai = new Saida(null, "1250", "2022-10-10", "Cpfl", "Boleto", "A Pagar", usu1, mes1);
		
		

		usu1.getEntrada().addAll(Arrays.asList(ent));
		usu1.getSaida().addAll(Arrays.asList(sai));
		mes1.getEntrada().addAll(Arrays.asList(ent));
		mes1.getSaida().addAll(Arrays.asList(sai));

		this.usuarioRepository.saveAll(Arrays.asList(usu1));
		this.mesRepository.saveAll(Arrays.asList(mes1));
		this.entradaRepository.saveAll(Arrays.asList(ent));
		this.saidaRepository.saveAll(Arrays.asList(sai));
		
	}

}
