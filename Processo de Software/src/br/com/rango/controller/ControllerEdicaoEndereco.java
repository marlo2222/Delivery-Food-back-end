package br.com.rango.controller;



import br.com.rango.model.Model;
import br.com.rango.views.*;

public class ControllerEdicaoEndereco {
	public Model model;
	public ViewNotificacoes notificacao;
	public ViewDadosCadastro dados;
	public ViemUsuarioEdicaoEndereco edicaoEndereco = new ViemUsuarioEdicaoEndereco();

	public ControllerEdicaoEndereco(Model model,ViewDadosCadastro dados,ViewNotificacoes notificacao) {
		this.model = model;
		this.dados = dados;
		this.notificacao = notificacao;
	}
	
	public void editarEndereco() {
		char opcao;
		do {
			opcao = edicaoEndereco.menuEditarEndereco();
			switch (opcao) {
			//modificar endereco padrao
			case '1':
				String lista = model.ListaEnderecosUsuario();
				if(lista != "") {
					model.modificarEnderecoPadrao(edicaoEndereco.listaRestaurantesUsuario(lista));
					notificacao.notificacao("Endereço definido");
				}else {
					notificacao.notificacao("Lista vazia");
				}
				break;
			//cadastra novo endereco
			case '2':
				model.adicionarEndereco(dados.endereco());
			break;
			case '3':
			break;

			default:
				break;
			}
		} while (opcao != '4');
	}
}
