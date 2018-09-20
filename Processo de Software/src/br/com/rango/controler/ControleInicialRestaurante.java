package br.com.rango.controler;

import br.com.rango.model.Model;
import br.com.rango.viens.PreTelaRestaurante;
import br.com.rango.viens.ViemDadoscadastro;
import br.com.rango.viens.ViemNotificacoes;

public class ControleInicialRestaurante {
	public PreTelaRestaurante telaPro = new PreTelaRestaurante();
	public ViemDadoscadastro dados = new ViemDadoscadastro();
	public ViemNotificacoes notificacoes = new ViemNotificacoes();
	public ControleProprietario controleProprietario;
	public Model model;

	public ControleInicialRestaurante(Model model, ControleProprietario controleproprietario) {
		this.model = model;
		this.controleProprietario = controleproprietario;
		
	}

	public void controleTelaLogin() {
		char opcao;
		do {
			opcao = telaPro.menuLogin();
			switch (opcao) {
			// logar proprietario
			case '1':
				if (model.logar(dados.cpf(), dados.senha()) == false) {
					notificacoes.msgUsuarioInvalido();
				} else {
					controleProprietario.telaProprietario();
				}
				break;
			// cadastra proprietario
			case '2':
				if (model.cadastraProprieatrio(dados.nome(), dados.email(), dados.cpf(), dados.telefone()) == true) {
					notificacoes.mgsUsuarioCadastrado();
					controleProprietario.telaProprietario();
				} else
					notificacoes.mgsUsuarioExistente();
				break;
			default:
				break;
			}

		} while (opcao != '3');
	}
}
