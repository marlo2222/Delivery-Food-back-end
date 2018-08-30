package Negocios;
import EsDadosTemp.Hash;
import Verificacoes.AutenticarDados;
import Viem.ViemCadastro;

public class Controler {
	ViemCadastro viemCadastro = new ViemCadastro();
	AutenticarDados autenticacao = new AutenticarDados();
	Hash ListaProprietarios = new Hash();

	public void cadastraProprieatrio() {
		Proprietario proprietario = new Proprietario();
		
		proprietario.setNomeProprietario(viemCadastro.nome());
		proprietario.setEmailProprietario(viemCadastro.email());
		proprietario.setCpf(viemCadastro.cnpj());
		proprietario.setContatoProprietario(viemCadastro.telefone());
		proprietario.setRgProprietario(viemCadastro.rg());
		
		autenticacao.AutenticarDadosProprietario(proprietario);
		
	}
	

}
