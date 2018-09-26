package br.com.rango.controller;

import br.com.rango.model.*;
import br.com.rango.views.*;

public class ControllerEdicaoUsuario {
	public Model model;
	public ViemMenuUsuarioEdicao usuarioEdicao = new ViemMenuUsuarioEdicao();
	public ViewNotificacoes notificacao = new ViewNotificacoes();
	public ViewDadosCadastro dados =  new ViewDadosCadastro();

	public ControllerEdicaoUsuario(Model model) {
		this.model = model;
	}

	public void edicaoDadosUsuario() {
		char opcao;
		do {
			opcao = usuarioEdicao.menuEdicao();
			switch (opcao) {
			//atualizar informaçoes
			case '1':
				char escolha = usuarioEdicao.menuEscolha();
				if (escolha == '1') 
					model.AtualizarUsuario(1, dados.email());
				if (escolha == '2') 
					model.AtualizarUsuario(2, dados.telefone());
				if (escolha == '3')
					model.AtualizarUsuario(3, dados.senha());
				if (escolha == '4') {
				} else {
					notificacao.notificacao("opção invalida!!!!");
				}

				break;
			//modificar endereço
			case '2':
				break;

			default:
				break;
			}
		} while (opcao != '3');
	}
}
