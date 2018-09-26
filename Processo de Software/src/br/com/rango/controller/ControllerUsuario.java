package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.ViemMenuUsuario;

public class ControllerUsuario {
	public Model model;
	public ViemMenuUsuario viemMenuUsuario = new ViemMenuUsuario();
	public ControllerEdicaoUsuario controleEdicaoUsuario;

	public ControllerUsuario(Model model) {
		this.model = model;
		this.controleEdicaoUsuario = new ControllerEdicaoUsuario(model);
	}

	public void menuUsuario() {
		char opcao;
		System.out.println("entrou");
		do {
			opcao = viemMenuUsuario.menuUsuario();
			switch (opcao) {
			//realizar pedido
			case '1':
				
				break;
			//atualizar dados
			case '2':
			controleEdicaoUsuario.edicaoDadosUsuario();
				break;
			default:
				break;
			}

		} while (opcao != '3');
	}
}
