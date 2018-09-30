package br.com.rango.controller;

import br.com.rango.model.*;
import br.com.rango.views.*;

public class ControllerAdmRestaurante {
	public Model model;
	public ViemAdmRestaurante admRestaurante = new ViemAdmRestaurante();
	public ViewCadastraCardapio prato = new ViewCadastraCardapio();
	public ViewNotificacoes notificaçao = new ViewNotificacoes();
	public ControllerEdicaoCardapio editCardapio;

	public ControllerAdmRestaurante(Model model) {
		this.model = model;
		this.editCardapio = new ControllerEdicaoCardapio(model);
	}

	public void AdmRestaurante() {
		char opcao;
		do {
			opcao = admRestaurante.telaAdmRestaurante();
			switch (opcao) {
			// fila de pedidos
			case '1':

				break;
			// adiconar prato ao cardapio
			case '2':
				if (model.CadastraPrato(new Prato(prato.nomePrato(),prato.Ingredientes(),prato.Selo(),prato.porcao(),prato.preco())) == true) {
					notificaçao.notificacao("prato adicionado ao cardapio");
				} else {
					notificaçao.notificacao("parece que esse prato ja foi cadastrado amiguinho");
				}
				break;
			// editar cardapio;
			case '3':
				editCardapio.editarCardapio();
				break;
			default:
				break;
			}
		} while (opcao != '4');
	}

}
