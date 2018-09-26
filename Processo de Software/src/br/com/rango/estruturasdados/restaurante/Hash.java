package br.com.rango.estruturasdados.restaurante;

import br.com.rango.model.Proprietario;

public class Hash {
	public ListaEnHash[] hash = new ListaEnHash[11];

	private int h(int chave) {
		int c = chave % 10000;
		c = c % getHash().length;
		return c;
	}

	public void adicionar(Proprietario proprietario, String chave) {
		int indice = h(dig(chave));

		if (getHash()[indice] == null)
			getHash()[indice] = new ListaEnHash();
		getHash()[indice].adicionar(proprietario);

	}
	
	//busca no momento do cadastro para saber se aquele usuario ja existe
	public boolean buscar(String cpf, String usuario) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHash aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getCpf().equals(cpf) && aux.proprietario.getNome().equals(usuario))
					return false;
			}
		}
		return true;
	}
	//busca no momento de autenticaçã
	public Proprietario buscarSenha(String cpf, String chave) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHash aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getSenha().equals(chave) && aux.proprietario.getCpf().equals(cpf))
					return aux.proprietario;
			}
		}
		return null;
	}
	//cpf esta como string estamos retornando ele como inteiro ignorando o digito mais a esquerda
	private int dig(String cpf) {
		String num = "";
		for (int i = 2; i < cpf.length(); i++)
			num += cpf.charAt(i);
		return Integer.parseInt(num);
	}

	public int length() {
		// TODO Auto-generated method stub
		return getHash().length;
	}

	public ListaEnHash[] getHash() {
		return hash;
	}

	public void setHash(ListaEnHash[] hash) {
		this.hash = hash;
	}

}
