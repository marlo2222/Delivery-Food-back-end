package Negocios;
import Verificacoes.AutenticarDados;
import Viem.ViemCadastro;

public class Controler {
	ViemCadastro viemCadastro = new ViemCadastro();
	AutenticarDados autenticacao = new AutenticarDados();

	public void cadastraProprieatrio() {
		Proprietario proprietario = new Proprietario();
		
		//proprietario.setNomeProprietario(viemCadastro.nome());
		//proprietario.setEmailProprietario(viemCadastro.email());
		proprietario.setCnpj(viemCadastro.cnpj());
		//proprietario.setContatoProprietario(viemCadastro.telefone());
		//proprietario.setRgProprietario(viemCadastro.rg());
		
		//autenticacao.verificarEmail(proprietario.getEmailProprietario());
		autenticacao.verificaCNPJ(proprietario.getCnpj());
		
	}
	

}
