package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.TelaPrincipalProprietario;
import br.com.rango.views.ViewDadosRestaurante;
import br.com.rango.views.ViewNotificacoes;

public class ControllerProprietario {
	public Model model;
	public TelaPrincipalProprietario menuPro = new TelaPrincipalProprietario();
	public ViewNotificacoes notificacoes = new ViewNotificacoes();
	public ViewDadosRestaurante dRestaurante = new ViewDadosRestaurante();
	public ControllerEdicaoRestaurante edicaoRestaurante;
	public ControllerAdmRestaurante admRestaurante;

	public ControllerProprietario(Model model) {
		this.model = model;
		this.edicaoRestaurante = new ControllerEdicaoRestaurante(model);
		this.admRestaurante = new ControllerAdmRestaurante(model);
	}

	public void telaProprietario() {
		char opcao;
		do {
			opcao = menuPro.menuPropri();
			switch (opcao) {
			//entra em restaurante x
			case '1':
				if(model.definirRestaurantePadrao(notificacoes.ListaRestaurantes(model.visualizaRestaurantes()))==true) {
					admRestaurante.AdmRestaurante();
				}else {
					notificacoes.notificacao("Lista de restaurantes vazia!");
				}
				break;
			// cadastro restaurante
			case '2':
				if (model.cadastroRestaurante(dRestaurante.nomeRestaurante(), dRestaurante.horarioFuncionamento(),
						dRestaurante.endereco(), dRestaurante.telefoneContato()) == false) {
					notificacoes.notificacao(
							"Nao foi possivel cadastra o restaurante.\n estabelecimento já cadastrado no sistema");
				} else {
					notificacoes.notificacao("Restaurante cadastrado com sucesso!");
				}
				break;
			// chamada de edicao de restaurante.
			case '3':
				edicaoRestaurante.telaEdicaoRest();
				break;
			default:
				break;
			}

		} while (opcao != '4');
	}

}
