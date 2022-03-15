package com.api.finaceiro.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.api.finaceiro.domain.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
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

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();

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

}
