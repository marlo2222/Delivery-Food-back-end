package br.com.rango.model;

public class Prato {
	
	private String nome;
	private String ingredientes;
	private String selo; //informando por exemplo sem glutem ou sem lactose
	private String porcao; //exemplo porcao de coxinhas 5 unidades
	private float preco;
	

	public Prato(String nomePrato, String ingredientes, String selo, String porcao, float preco) {
		this.setNome(nomePrato);
		this.setIngredientes(ingredientes);
		this.setSelo(selo);
		this.setPorcao(porcao);
		this.setPreco(preco);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getSelo() {
		return selo;
	}
	public void setSelo(String selo) {
		this.selo = selo;
	}
	public String getPorcao() {
		return porcao;
	}
	public void setPorcao(String porcao) {
		this.porcao = porcao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
