package EsDadosTemp;

import Negocios.Proprietario;

public class Hash {
	private ListaEnHash[] hash = new ListaEnHash[11];

	private int h(int chave) {
		int a, b, c;
		a = chave / 100;
		b = chave % 100;
		a = a * a;
		b = b * b;
		c = a + b;
		c = c % hash.length;
		return c;
	}

	public void adicionar(Proprietario proprietario, int chave) {
		int indice = h( chave);
		
		if (hash[indice] == null)
			hash[indice] = new ListaEnHash();
		hash[indice].adicionar(proprietario);

	}

	public Proprietario buscar(String cpf, int chave, String usuario) {
		int indice = h(chave);
		if (hash[indice] != null) {
			for (NoHash aux = hash[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getSenha() == chave && aux.proprietario.getNomeProprietario().equals(usuario))
					return aux.proprietario;
			}
		}
		return null;
	}

}
