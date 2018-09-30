package br.com.rango.controller;

import br.com.rango.model.*;
import br.com.rango.views.*;

public class ControllerEdicaoCardapio {
	public Model model;
	public ViewAdmRestauranteEditarCardapio editCardapio = new ViewAdmRestauranteEditarCardapio();
	public ViewNotificacoes notificacao = new ViewNotificacoes();
	public ViewCadastraCardapio dados = new ViewCadastraCardapio();

	public ControllerEdicaoCardapio(Model model) {
		this.model = model;
	}
	
	public void editarCardapio() {
		char opcao2;
		do {
			opcao2 = editCardapio.editarCardapio();
			switch (opcao2) {
			//remover prato
			case '1':
				String lista = model.liPratos();
				if(lista != "") {
				if(model.removerPrato(editCardapio.removePrato(lista))==true)
					notificacao.notificacao("Prato removido");
				else
					notificacao.notificacao("Não  foi possivel remover o prato");
				}else {
					notificacao.notificacao("Cardapio vazio");
				}
				break;
				//editar prato
			case '2':
				String lista2 = model.liPratos();
				int indice,campo;
				if(lista2 != "") {
					indice = editCardapio.escEditarPrato(lista2);
					campo = editCardapio.CampoEdicao();
					switch (indice) {
					case 1:
						model.editarPrato(indice, campo, dados.nomePrato());
						break;
					case 2:
						model.editarPrato(indice, campo, dados.Ingredientes());
						break;
					case 3:
						model.editarPrato(indice, campo, dados.Selo());
						break;
					case 4:
						model.editarPrato(indice, campo, dados.porcao());
						break;
					case 5:
						model.editarPrato(indice, dados.preco());
						break;
					default:
						break;
					}
				}else {
					notificacao.notificacao("Cardapio vazio");
				}

				break;

			default:
				break;
			}

		} while (opcao2 != '3');
	}

}
