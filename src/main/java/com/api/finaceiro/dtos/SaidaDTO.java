package com.api.finaceiro.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.api.finaceiro.domain.Saida;

public class SaidaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo valor é requerido")
	@Length(min = 3, max = 100, message = "O campo nome deve ter emtre 3 e 100 caracteres")
	private String valor;
	@NotEmpty(message = "Campo data é requerido")
	@Length(min = 3, max = 10, message = "O campo data deve ter emtre 3 e 10 caracteres")
	private String data;
	@NotEmpty(message = "Campo descrição é requerido")
	@Length(min = 3, max = 20, message = "O campo descrição deve ter emtre 3 e 20 caracteres")
	private String descricao;
	@NotEmpty(message = "Campo tipo é requerido")
	@Length(min = 3, max = 32, message = "O campo tipo deve ter emtre 3 e 32 caracteres")
	private String tipo;
	@NotEmpty(message = "Campo status é requerido")
	@Length(min = 3, max = 10, message = "O campo status deve ter emtre 3 e 10 caracteres")
	private String status;
	
	public SaidaDTO(Saida obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.data = obj.getData();
		this.descricao = obj.getDescricao();
		this.tipo = obj.getTipo();
		this.status = obj.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
