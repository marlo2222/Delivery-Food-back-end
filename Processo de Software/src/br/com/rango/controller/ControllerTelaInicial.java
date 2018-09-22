package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.*;

public class ControllerTelaInicial {
	private Model model;
	public TelaInicial preTela;
	public ViewNotificacoes notificacoes = new ViewNotificacoes();
	public ViewDadosCadastro dados = new ViewDadosCadastro();
	public EnderecoAlternativo preTelaEnderecoAlternativo;
	public ViewEnderecoAlternativo endAlternativo = new ViewEnderecoAlternativo();
	public ControllerInicialRestaurante controlerestaurante;
	public ControllerProprietario controleProprietario;

	public ControllerTelaInicial() {
		super();
	}

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

	// controler inicial, primeiro menu
	public void acaoTelaInicial() {
		char opcao;
		do {
			opcao = preTela.telaInicial();
			switch (opcao) {
			// logar usuario
			case '1':
				if (model.logarUsuario(dados.cpf(), dados.senha()) == false) {
					notificacoes.notificacao("Usuário invalido !");
				} else {
					notificacoes.notificacao("Bem vindo!");
					//OBS:aqui vem a chamada para a tela do usuario
				}
				break;
			// cadastra usuario
			case '2':
				if (model.cadastraUsuario(dados.nome(), dados.email(), dados.cpf(), dados.telefone()) == true) {
					notificacoes.notificacao("Usuário cadastrado com sucesso!");
					// OBS: aqui vem a chamada para a tela usuario
				} else {
					notificacoes.notificacao("Usuario ja castrado no sistema com essas informaçoes!");}
				break;
			// cadastra restaurante
			case '3':
				controlerestaurante.controleTelaLogin();
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

	public int definirSenha() {
		return dados.senha();
	}

	public String DefinirCpf() {
		return dados.cpf();
	}
}
