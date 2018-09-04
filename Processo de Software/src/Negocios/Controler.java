package Negocios;

import EsDadosTemp.Hash;
import Verificacoes.AutenticarDados;
import Viem.ViemDadosRestaurante;
import Viem.ViemDadoscadastro;
import Viem.ViemNotificacoes;
import Viem.ViemPropritario;

public class Controler {
	ViemDadoscadastro viemCadastro = new ViemDadoscadastro();
	ViemNotificacoes viemNotificacoes = new ViemNotificacoes();
	AutenticarDados autenticacao = new AutenticarDados();
	ViemPropritario telaPro = new ViemPropritario();
	ViemDadosRestaurante dRestaurante = new ViemDadosRestaurante();
	private Hash liUsuarios = new Hash();

	public void cadastraProprieatrio() {
	
		Proprietario proprietario = new Proprietario();

		proprietario.setNomeProprietario(viemCadastro.nome());
		proprietario.setEmailProprietario(viemCadastro.email());
		proprietario.setCpf(viemCadastro.cnpj());
		proprietario.setContatoProprietario(viemCadastro.telefone());
		proprietario.setRgProprietario(viemCadastro.rg());

		if (liUsuarios.buscar(proprietario.getCpf(),proprietario.getNomeProprietario()) == true) {
			if (autenticacao.AutenticarDados(proprietario) == true) {
				proprietario.setSenha(viemCadastro.senha());
				liUsuarios.adicionar(proprietario,proprietario.getCpf());
				

			}
		} else {
			viemNotificacoes.mgsUsuarioExistente();
		}
	telaPro.telaPro();
}
	public void cadastroRestaurante() {
		Restaurantes restaurante = new Restaurantes();
		
	}
}