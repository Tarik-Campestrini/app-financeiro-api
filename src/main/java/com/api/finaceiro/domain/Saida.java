package com.api.finaceiro.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Saida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "mes_id")
	private Mes mes;

	public Saida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Saida(Integer id, String valor, String data, String descricao, String tipo, String status, Usuario usuario,
			Mes mes) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
		this.tipo = tipo;
		this.status = status;
		this.usuario = usuario;
		this.mes = mes;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saida other = (Saida) obj;
		return Objects.equals(id, other.id);
	}

}
