package EsDadosTemp;

import Negocios.Proprietario;

public class Hash {
	private ListaEnHash[] hash = new ListaEnHash[11];

	private int h(int chave) {
		int c = chave % 10000;
		c = c % hash.length;
		return c;
	}

	public void adicionar(Proprietario proprietario, String chave) {
		int indice = h(dig(chave));
		
		if (hash[indice] == null)
			hash[indice] = new ListaEnHash();
		hash[indice].adicionar(proprietario);

	}

	public Proprietario buscarSenha(String cpf, int chave, String usuario) {
		int indice = h(dig(cpf));
		if (hash[indice] != null) {
			for (NoHash aux = hash[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getSenha() == chave && aux.proprietario.getNomeProprietario().equals(usuario))
					return aux.proprietario;
			}
		}
		return null;
	}public boolean buscar(String cpf, String usuario) {
		int indice = h(dig(cpf));
		if (hash[indice] != null) {
			for (NoHash aux = hash[indice].inicio; aux != null; aux = aux.prox) {
				if (aux.proprietario.getCpf() == cpf && aux.proprietario.getNomeProprietario().equals(usuario))
					return false;
			}
		}
		return true;
	}
	
	
	public int dig(String cpf) {
		String num = "";
		for(int i = 2; i <cpf.length(); i++)
			num+= cpf.charAt(i);
		return Integer.parseInt(num);
	}

}
