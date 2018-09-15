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
	public TelaEdicaoRestauranteEscolha telaEscolhaRest = new TelaEdicaoRestauranteEscolha();

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

	// controle apos o proprietario se logar
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

	// Controle tela de edição
	public void telaEdicaoRest() {
		char opcao;
		do {
			opcao = telaEdicaoRest.menuEditarRest();
			switch (opcao) {
			// atualizar informaçoes
			case '1':
				String lista1 = model.listaRest();
				int posicao,campo;
				if (lista1 != "") {
					posicao = telaEscolhaRest.selecionarRestEdicao(lista1);
					campo = telaEscolhaRest.campoParaModificar();
					if (campo == 1)
						model.AtualizarRest(posicao, dRestaurante.nomeRestaurante());
					if (campo == 2)
						model.AtualizarRest(posicao, dRestaurante.horarioFuncionamento());
					if (campo == 3)
						model.AtualizarRest(posicao, dRestaurante.endereco());
					if (campo == 4)
						model.AtualizarRest(posicao, dRestaurante.telefoneContato());
					if (campo > 4)
						notificacoes.notificacao("opcao invalida");
					
				}else {
					notificacoes.notificacao("Lista vazia");
				}
				break;
			// remover restaurante:
			case '2':
				String lista = model.listaRest();
				if (lista != "") {
					notificacoes.notificacao(model.revomerRestaurante(notificacoes.Lista(lista)));
				} else {
					notificacoes.notificacao("Lista vazia");
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
