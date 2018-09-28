package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.ViewDadosRestaurante;
import br.com.rango.views.ViewEdicaoRestaurante;
import br.com.rango.views.ViewEscolhaModificacaoRestaurante;
import br.com.rango.views.ViewNotificacoes;

public class ControllerEdicaoRestaurante {
	public Model model;
	public ViewEdicaoRestaurante telaEdicaoRest = new ViewEdicaoRestaurante();
	public ViewEscolhaModificacaoRestaurante telaEscolhaRest = new ViewEscolhaModificacaoRestaurante();
	public ViewDadosRestaurante dRestaurante = new ViewDadosRestaurante();
	public ViewNotificacoes notificacoes = new ViewNotificacoes();

	public ControllerEdicaoRestaurante(Model model) {
		this.model = model;
	}

	public void telaEdicaoRest() {
		char opcao;
		do {
			opcao = telaEdicaoRest.menuEditarRest();
			switch (opcao) {
			// atualizar informaçoes
			case '1':
				String lista1 = model.listaRest();
				int posicao, campo;
				if (lista1 != "") {
					posicao = telaEscolhaRest.selecionarRestEdicao(lista1);
					campo = telaEscolhaRest.campoParaModificar();
					if (campo == 1)
						model.AtualizarRest(posicao, dRestaurante.nomeRestaurante());
					if (campo == 2)
						model.AtualizarRest(posicao, dRestaurante.horarioFuncionamento());
					if (campo == 3)
						model.AtualizarRest(posicao, dRestaurante.endereco());
					if (campo == 4)
						model.AtualizarRest(posicao, dRestaurante.telefoneContato());
					if (campo > 4)
						notificacoes.notificacao("opcao invalida");

				} else {
					notificacoes.notificacao("Lista vazia");
				}
				break;
			// remover restaurante:
			case '2':
				String lista = model.listaRest();
				if (lista != "") {
					if (model.revomerRestaurante(notificacoes.Lista(lista)) == true) {
						notificacoes.notificacao("Restaurante removido com sucesso!");
					} else {
						notificacoes.notificacao("Não foi possivel remover o restaurante");
					}
				} else {
					notificacoes.notificacao("Lista vazia");
				}
				break;

			default:
				break;
			}
		} while (opcao != '3');
	}
}
