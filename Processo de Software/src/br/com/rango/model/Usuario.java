package br.com.rango.model;

import java.util.ArrayList;

public class Usuario {
	
	private String nome;
	private String email;
	private String cpf;
	private String contato;
	private String Senha;
	private Endereco enderecoPadrao;
	private ArrayList<Endereco> listaEnderecos; 

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
	public Endereco getEnderecoPadrao() {
		return enderecoPadrao;
	}

	public void setEnderecoPadrao(Endereco enderecoPadrao) {
		this.enderecoPadrao = enderecoPadrao;
	}

	public ArrayList<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(ArrayList<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
}
