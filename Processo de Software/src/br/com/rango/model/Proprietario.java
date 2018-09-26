package br.com.rango.model;

import java.util.ArrayList;

public class Proprietario {
	private String nome;
	private String email;
	private String cpf;
	private String contato;
	private String Senha;
	public ArrayList<Restaurantes> restaurante;

	public Proprietario() {
		super();
	}

	public Proprietario(String nome, String email, String cpf, String contato, String senha) {
		setNome(nome);
		setEmail(email);
		setCpf(cpf);
		setContato(contato);
		setSenha(senha);

	}

	public Proprietario(String nome, String email, String cpf, String telefone) {
		setNome(nome);
		setEmail(email);
		setCpf(cpf);
		setContato(telefone);
	}

	public ArrayList<Restaurantes> getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(ArrayList<Restaurantes> restaurante) {
		this.restaurante = restaurante;
	}

	public void setRestaurante(Restaurantes restaurantes) {
		// TODO Auto-generated method stub

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

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
