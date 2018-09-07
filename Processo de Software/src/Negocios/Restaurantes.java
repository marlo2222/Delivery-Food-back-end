package Negocios;

import java.util.ArrayList;

public class Restaurantes {
	private String nome;
	private String horarioFucionamento;
	private Endereco localiza��o;
	private String telefoneContato;
	private ArrayList<Cardapio> cardapio;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!=null)this.nome = nome;
	}
	public String getHorarioFucionamento() {
		return horarioFucionamento;
	}
	public void setHorarioFucionamento(String horarioFucionamento) {
		if(horarioFucionamento!=null)this.horarioFucionamento = horarioFucionamento;
	}
	public Endereco getLocaliza��o() {
		return localiza��o;
	}
	public void setLocaliza��o(Endereco localiza��o) {
		if(localiza��o!=null)this.localiza��o = localiza��o;
	}
	public String getTelefoneContato() {
		return telefoneContato;
	}
	public void setTelefoneContato(String telefoneContato) {
		if(telefoneContato!=null)this.telefoneContato = telefoneContato;
	}
	public ArrayList<Cardapio> getCardapio() {
		return cardapio;
	}
	public void setCardapio(ArrayList<Cardapio> cardapio) {
		this.cardapio = cardapio;
	}
	
}
