package Negocios;

import EsDadosTemp.Hash;
import Verificacoes.AutenticarDados;
import Viem.ViemCadastro;
import Viem.ViemNotificacoes;

public class Controler {
	ViemCadastro viemCadastro = new ViemCadastro();
	ViemNotificacoes viemNotificacoes;
	AutenticarDados autenticacao = new AutenticarDados();
	private Hash liUsuarios = new Hash();

	public void cadastraProprieatrio() {
		Proprietario proprietario = new Proprietario();

		proprietario.setNomeProprietario(viemCadastro.nome());
	//	proprietario.setEmailProprietario(viemCadastro.email());
		proprietario.setCpf(viemCadastro.cnpj());
		//proprietario.setContatoProprietario(viemCadastro.telefone());
		//proprietario.setRgProprietario(viemCadastro.rg());

		if (liUsuarios.buscar(proprietario.getCpf(), proprietario.getSenha(),
				proprietario.getNomeProprietario()) == null) {
			if (autenticacao.AutenticarDadosProprietario(proprietario) == true) {
				proprietario.setSenha(viemCadastro.senha());
				liUsuarios.adicionar(proprietario, proprietario.getSenha());
				viemNotificacoes.mgsUsuarioCadastrado();
				
			}
		} else {
			viemNotificacoes.mgsUsuarioExistente();
		}
		
		Proprietario aux = liUsuarios.buscar(proprietario.getCpf(), proprietario.getSenha(),
				proprietario.getNomeProprietario());
		System.out.println(aux.getNomeProprietario());

	}

}
