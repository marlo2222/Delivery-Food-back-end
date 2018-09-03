package EsDadosTemp;

import Negocios.Proprietario;

public class NoHash {
	public NoHash prox, ant;
	public Proprietario proprietario;

	public NoHash(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}
