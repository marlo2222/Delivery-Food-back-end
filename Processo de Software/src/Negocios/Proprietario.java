package Negocios;

import java.util.ArrayList;

public class Proprietario {
	private String nomeProprietario;
	private String emailProprietario;
	private String cnpj;
	private String contatoProprietario;
	private String rgProprietario;
	protected int Senha;
	private ArrayList<Restaurantes> restaurante;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if(cnpj != null) this.cnpj = cnpj;
	}

	public String getContatoProprietario() {
		return contatoProprietario;
	}

	public void setContatoProprietario(String contatoProprietario) {
		if(contatoProprietario != null )this.contatoProprietario = contatoProprietario;
	}

	public String getRgProprietario() {
		return rgProprietario;
	}

	public void setRgProprietario(String rgProprietario) {
		if(rgProprietario != null)this.rgProprietario = rgProprietario;
	}

}
