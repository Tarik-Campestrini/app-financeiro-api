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
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Campo nome é requerido")
	@Length(min = 3, max = 100, message = "O campo nome deve ter emtre 3 e 100 caracteres")
	private String nome;
	@NotEmpty(message = "Campo sobrenome é requerido")
	@Length(min = 3, max = 100, message = "O campo sobrenome deve ter emtre 3 e 100 caracteres")
	private String sobrenome;
	@NotEmpty(message = "Campo e-mail é requerido")
	@Length(min = 3, max = 20, message = "O campo e-mail deve ter emtre 3 e 20 caracteres")
	private String email;
	@NotEmpty(message = "Campo senha é requerido")
	@Length(min = 3, max = 10, message = "O campo senha deve ter emtre 3 e 10 caracteres")
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Entrada> entrada = new ArrayList<>();

	@OneToMany(mappedBy = "usuario")
	private List<Saida> saida = new ArrayList<>();

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String nome, String sobrenome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
