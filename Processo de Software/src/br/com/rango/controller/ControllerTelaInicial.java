package br.com.rango.controller;

import br.com.rango.model.Model;
import br.com.rango.views.*;

public class ControllerTelaInicial {
	private Model model;
	public TelaInicial preTela;
	public ViewNotificacoes notificacoes = new ViewNotificacoes();
	public ViewDadosCadastro dados = new ViewDadosCadastro();
	public TelaEndereco preTelaEndereco;
	public ViewEndereco endereco = new ViewEndereco();
	public ControllerInicialRestaurante controlerestaurante;
	public ControllerProprietario controleProprietario;
	public ViewEndereco dadosEnd = new ViewEndereco();

	public ControllerTelaInicial() {
		super();
	}

	public ControllerTelaInicial(Model model, TelaInicial preTela) {
		this.model = model;
		this.preTela = preTela;
		this.controlerestaurante = new ControllerInicialRestaurante(model, controleProprietario);
		this.controleProprietario = new ControllerProprietario(model);

	}

	public ControllerTelaInicial(Model model, TelaEndereco preTelaEnderecoAlternativo) {
		this.model = model;
		this.preTelaEndereco = preTelaEnderecoAlternativo;
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
				if ((model.cadastraUsuario(dados.nome(), dados.email(), dados.cpf(), dados.telefone()) == true) && (model.cadastroEndereco(dadosEnd.nomeDarua(), dadosEnd.NumCasa(), dadosEnd.nomeDoBairro(), dadosEnd.nomeMunicipio(), dadosEnd.nomeEstado()) == true)) {
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
			opcao = preTelaEndereco.TelaDeEntrega();
			switch (opcao) {
			case '1':
				// usar endereco cadastrado
				break;
			case '2':
				if (model.cadastroEndereco(endereco.nomeDarua(), endereco.NumCasa(),
						endereco.nomeDoBairro(), endereco.nomeMunicipio(),
						endereco.nomeEstado()) == false) {
					endereco.mgsEnderecoDeEntregaErro();
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
