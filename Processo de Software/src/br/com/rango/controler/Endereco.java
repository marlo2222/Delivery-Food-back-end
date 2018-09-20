package br.com.rango.controler;

public class Endereco {
	private String rua;
	private String bairro;
	private String estado;
	private String municipio;
	private String numero;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		if (rua != null)
			this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if (bairro != null)
			this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		if (estado != null)
			this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		if (municipio != null)
			this.municipio = municipio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
