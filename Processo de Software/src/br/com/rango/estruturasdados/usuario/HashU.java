package br.com.rango.estruturasdados.usuario;

import br.com.rango.model.*;

public class HashU {
	public ListaEnHashU[] hash = new ListaEnHashU[11];

	private int h(int chave) {
		int c = chave % 10000;
		c = c % getHash().length;
		return c;
	}

	public void adicionar(Usuario usuario, String chave) {
		int indice = h(dig(chave));

		if (getHash()[indice] == null)
			getHash()[indice] = new ListaEnHashU();
		getHash()[indice].adicionar(usuario);

	}
	//nao esta sendo usado!!!!!!
	/*public Proprietario buscarSenha(String cpf, int chave, String usuario) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHash aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getSenha() == chave && aux.proprietario.getNome().equals(usuario))
					return aux.proprietario;
			}
		}
		return null;
	}*/
	//busca no momento do cadastro para saber se aquele usuario ja existe
	public boolean buscar(String cpf, String usuario) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHashU aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.usuario.getCpf() == cpf && aux.usuario.getNome().equals(usuario))
					return false;
			}
		}
		return true;
	}
	//busca no momento de autenticaçã
	public Usuario buscarSenha(String cpf, String chave) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHashU aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.usuario.getSenha() == chave && aux.usuario.getCpf().equals(cpf))
					return aux.usuario;
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

	public ListaEnHashU[] getHash() {
		return hash;
	}

	public void setHash(ListaEnHashU[] hash) {
		this.hash = hash;
	}

}
