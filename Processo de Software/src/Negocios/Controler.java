package Negocios;

public class Controler {
	ViemCadastro viemCadastro = new ViemCadastro();

	public void cadastraProprieatrio() {
		Proprietario proprietario = new Proprietario();
		
		proprietario.setNomeProprietario(viemCadastro.nome());
	}
}
