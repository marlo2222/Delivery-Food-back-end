package Negocios;

import Viem.*;

public class Controler {
	public Model model;
	public PreTela preTela;
	public ViemNotificacoes notificacoes = new ViemNotificacoes();
	public ViemDadoscadastro dados = new ViemDadoscadastro();
	public ViemDadosRestaurante dRestaurante = new ViemDadosRestaurante();
	public PreTelaProprietario telaPro = new PreTelaProprietario();
	public TelaPrincipalProprietario menuPro = new TelaPrincipalProprietario();
	public TelaEdicaoRestaurante telaEdicaoRest = new TelaEdicaoRestaurante();

	public Controler(Model model, PreTela preTela) {
		this.model = model;
		this.preTela = preTela;
	}

	public Controler() {
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
					telaProprietario();
				}
				break;
			// cadastra
			case '2':

				break;
			// cadastra restaurante
			case '3':
				telaProprietarioLogin();
			default:
				break;
			}
		} while (opcao != '4');
	}

	// controle da tela cadastra restaurante
	public void telaProprietarioLogin() {
		char opcao;
		do {
			opcao = telaPro.menuLogin();
			switch (opcao) {
			// logar proprietario
			case '1':
				if (model.logar(dados.cpf(), dados.senha()) == false) {
					notificacoes.msgUsuarioInvalido();
				} else {
					telaProprietario();
				}
				break;
			// cadastra proprietario
			case '2':
				if (model.cadastraProprieatrio(dados.nome(), dados.email(), dados.cpf(), dados.telefone()) == true) {
					notificacoes.mgsUsuarioCadastrado();
					telaProprietario();
				} else
					notificacoes.mgsUsuarioExistente();
				break;
			default:
				break;
			}

		} while (opcao != '3');
	}

	// tela depois que o proprietario se loga
	public void telaProprietario() {
		char opcao;
		do {
			opcao = menuPro.menuPropri();
			switch (opcao) {
			// visualizar lista
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
				telaEdicaoRest();
				break;
			default:
				break;
			}

		} while (opcao != '4');
	}

	public void telaEdicaoRest() {
		char opcao;
		do {
			opcao = telaEdicaoRest.menuEditarRest();
			switch (opcao) {
			case '1':

				break;
			case '2':
				String lista = model.listaRest();
				if (lista != "") {
					notificacoes.msgRemoverRestaurante(model.revomerRestaurante(notificacoes.Lista(lista)));
				}else {
					notificacoes.msgRemoverRestaurante("Lista vazia");
				}
				break;

			default:
				break;
			}
		} while (opcao != '3');
	}

	public int definirSenha() {
		return dados.senha();
	}

	public String DefinirCpf() {
		return dados.cpf();
	}
}
