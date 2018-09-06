package Negocios;

import java.util.ArrayList;

public class Proprietario {
	private String nomeProprietario;
	private String emailProprietario;
	private String cpf;
	private String contatoProprietario;
	private int Senha;
	private ArrayList<Restaurantes> restaurante;
	
	public Proprietario(String nome,String email, String cpf,String contato,int senha) {
		setNomeProprietario(nome);
		setEmailProprietario(email);
		setCpf(cpf);
		setContatoProprietario(contato);
		setSenha(senha);
		
	}

	public Proprietario() {
		super();
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		if (nomeProprietario != null)
			this.nomeProprietario = nomeProprietario;
	}

	public String getEmailProprietario() {
		return emailProprietario;
	}

	public void setEmailProprietario(String emailProprietario) {
		if (emailProprietario != null)
			this.emailProprietario = emailProprietario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf != null) this.cpf = cpf;
	}

	public String getContatoProprietario() {
		return contatoProprietario;
	}

	public void setContatoProprietario(String contatoProprietario) {
		if(contatoProprietario != null )this.contatoProprietario = contatoProprietario;
	}

	public int getSenha() {
		return Senha;
	}

	public void setSenha(int senha) {
		Senha = senha;
	}

}
