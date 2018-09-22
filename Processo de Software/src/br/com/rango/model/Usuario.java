package br.com.rango.model;

public class Usuario {
	
	private String nome;
	private String email;
	private String cpf;
	private String contato;
	private int Senha;

	public Usuario(String nome, String email, String cpf, String contato) {
	this.setNome(nome);
	this.setEmail(email);
	this.setCpf(cpf);
	this.setContato(contato);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public int getSenha() {
		return Senha;
	}

	public void setSenha(int senha) {
		Senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
