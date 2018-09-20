package br.com.rango.controler;

import br.com.rango.model.Model;
import br.com.rango.viens.TelaPrincipalProprietario;
import br.com.rango.viens.ViemDadosRestaurante;
import br.com.rango.viens.ViemNotificacoes;

public class ControleProprietario {
	public Model model;
	public TelaPrincipalProprietario menuPro = new TelaPrincipalProprietario();
	public ViemNotificacoes notificacoes = new ViemNotificacoes();
	public ViemDadosRestaurante dRestaurante = new ViemDadosRestaurante();
	public ControleEdicaoRestaurante edicaoRestaurante;
	public ControleProprietario(Model model) {
		this.model = model;
		this.edicaoRestaurante = new ControleEdicaoRestaurante(model);
	}

	public void telaProprietario() {
		char opcao;
		do {
			opcao = menuPro.menuPropri();
			switch (opcao) {
			//visualizar restaurantes
			case '1':
				notificacoes.Listausuarios(model.visualizaRestaurantes());
				break;
			// cadastro restaurante
			case '2':
				if (model.cadastroRestaurante(dRestaurante.nomeRestaurante(), dRestaurante.horarioFuncionamento(),
						dRestaurante.endereco(), dRestaurante.telefoneContato()) == false) {
					notificacoes.msgRestauranteCad();
				}
				break;
			case '3':
				// chamada de edicao de restaurante.
		edicaoRestaurante.telaEdicaoRest();
				break;
			default:
				break;
			}

		} while (opcao != '4');
	}
	
}
