package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.*;

public class ControllerTelaInicial {
	public Model model;
	public TelaInicial preTela;
	public ViewNotificacoes notificacoes = new ViewNotificacoes();
	public ViewDadosCadastro dados = new ViewDadosCadastro();
	public EnderecoAlternativo preTelaEnderecoAlternativo;
	public ViewEnderecoAlternativo endAlternativo = new ViewEnderecoAlternativo();
	public ControllerInicialRestaurante controlerestaurante;
	public ControllerProprietario controleProprietario;

	public ControllerTelaInicial(Model model, TelaInicial preTela) {
		this.model = model;
		this.preTela = preTela;
		this.controlerestaurante = new ControllerInicialRestaurante(model, controleProprietario);
		this.controleProprietario = new ControllerProprietario(model);

	}

	public ControllerTelaInicial(Model model, EnderecoAlternativo preTelaEnderecoAlternativo) {
		this.model = model;
		this.preTelaEnderecoAlternativo = preTelaEnderecoAlternativo;
	}

	public ControllerTelaInicial() {
		super();
	}

	// controler inicial, primeiro menu
	public void acaoTelaInicial() {
		char opcao;
		do {
			opcao = preTela.telaInicial();
			switch (opcao) {
			// logar
			case '1':
				if (model.logar(dados.cpf(), dados.senha()) == false) {
					notificacoes.msgUsuarioInvalido();
				} else {
					controleProprietario.telaProprietario();
				}
				break;
			// cadastra
			case '2':

				break;
			// cadastra restaurante
			case '3':
				controlerestaurante.controleTelaLogin();
				// telaProprietarioLogin();
			default:
				break;
			}
		} while (opcao != '4');
	}

	public void acaoTelaEnderecoAlternativo() {
		char opcao;
		do {
			opcao = preTelaEnderecoAlternativo.TelaDeEntrega();
			switch (opcao) {
			case '1':
				// usar endereco cadastrado
				break;
			case '2':
				if (model.cadastroEnderecoAlternativo(endAlternativo.nomeDarua(), endAlternativo.NumCasa(),
						endAlternativo.nomeDoBairro(), endAlternativo.nomeMunicipio(),
						endAlternativo.nomeEstado()) == false) {
					endAlternativo.mgsEnderecoDeEntregaErro();
				}
				break;
			case '3':
				// sair da tela
			default:
				break;
			}
		} while (opcao != '4');
	}

	// Controle tela de edição

	public int definirSenha() {
		return dados.senha();
	}

	public String DefinirCpf() {
		return dados.cpf();
	}
}
