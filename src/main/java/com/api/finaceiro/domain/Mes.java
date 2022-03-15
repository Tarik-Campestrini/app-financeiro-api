package com.api.finaceiro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
public class Mes implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	@NotEmpty(message = "Campo mes é requerido")
	@Length(min = 3, max = 10, message = "O campo mes deve ter emtre 3 e 10 caracteres")
	private String mes;
	
	@OneToMany(mappedBy = "mes")
	private List<Entrada> entrada = new ArrayList<>();
	@OneToMany(mappedBy = "mes")
	private List<Saida> saida = new ArrayList<>();
	
	
	public Mes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Mes(Integer id, String mes) {
		super();
		this.id = id;
		this.mes = mes;
	}



	public Mes(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public List<Entrada> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<Entrada> entrada) {
		this.entrada = entrada;
	}

	public List<Saida> getSaida() {
		return saida;
	}

	public void setSaida(List<Saida> saida) {
		this.saida = saida;
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
		Mes other = (Mes) obj;
		return Objects.equals(id, other.id);
	}


	

	
}
