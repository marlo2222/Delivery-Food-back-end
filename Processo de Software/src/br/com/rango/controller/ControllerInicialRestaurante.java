package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.PreTelaRestaurante;
import br.com.rango.views.ViewDadosCadastro;
import br.com.rango.views.ViewNotificacoes;

public class ControllerInicialRestaurante {
	public PreTelaRestaurante telaPro = new PreTelaRestaurante();
	public ViewDadosCadastro dados = new ViewDadosCadastro();
	public ViewNotificacoes notificacoes = new ViewNotificacoes();
	public ControllerProprietario controleProprietario;
	public Model model;

	public ControllerInicialRestaurante(Model model, ControllerProprietario controleproprietario) {
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
