package br.com.rango.controler;

import br.com.rango.model.Model;
import br.com.rango.viens.ViemDadosRestaurante;
import br.com.rango.viens.ViemEdicaoRestaurante;
import br.com.rango.viens.ViemEscolhaModificacaoRestaurante;
import br.com.rango.viens.ViemNotificacoes;

public class ControleEdicaoRestaurante {
	public Model model;
	public ViemEdicaoRestaurante telaEdicaoRest = new ViemEdicaoRestaurante();
	public ViemEscolhaModificacaoRestaurante telaEscolhaRest = new ViemEscolhaModificacaoRestaurante();
	public ViemDadosRestaurante dRestaurante = new ViemDadosRestaurante();
	public ViemNotificacoes notificacoes = new ViemNotificacoes();

	public ControleEdicaoRestaurante(Model model) {
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
					notificacoes.notificacao(model.revomerRestaurante(notificacoes.Lista(lista)));
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
