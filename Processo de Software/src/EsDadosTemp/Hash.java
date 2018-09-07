package EsDadosTemp;

import Negocios.Proprietario;

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

	public Proprietario buscarSenha(String cpf, int chave, String usuario) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHash aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getSenha() == chave && aux.proprietario.getNomeProprietario().equals(usuario))
					return aux.proprietario;
			}
		}
		return null;
	}

	public boolean buscar(String cpf, String usuario) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHash aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getCpf() == cpf && aux.proprietario.getNomeProprietario().equals(usuario))
					return false;
			}
		}
		return true;
	}

	public Proprietario buscarSenha(String cpf, int chave) {
		int indice = h(dig(cpf));
		if (getHash()[indice] != null) {
			for (NoHash aux = getHash()[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getSenha() == chave && aux.proprietario.getCpf().equals(cpf))
					return aux.proprietario;
			}
		}
		return null;
	}

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
