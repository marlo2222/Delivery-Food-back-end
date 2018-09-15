package Negocios;

import Viem.*;

public class Controler {
	public Model model;
	public PreTela preTela;
	//public PreTelaEnderecoAlternativo preTelaEnderecoAlternativo;
	public ViemNotificacoes notificacoes = new ViemNotificacoes();
	public ViemDadoscadastro dados = new ViemDadoscadastro();
	public ViemDadosRestaurante dRestaurante = new ViemDadosRestaurante();
	public PreTelaProprietario telaPro = new PreTelaProprietario();
	public ViemPropritario menuPro = new ViemPropritario();
	public PreTelaEnderecoAlternativo preTelaEnderecoAlternativo;
	public ViemEnderecoAlternativo endAlternativo = new ViemEnderecoAlternativo();

	public Controler(Model model, PreTela preTela) {
		this.model = model;
		this.preTela = preTela;
	}
	
	public Controler(Model model, PreTelaEnderecoAlternativo preTelaEnderecoAlternativo) {
		this.model = model;
		this.preTelaEnderecoAlternativo = preTelaEnderecoAlternativo;
	}

	public Controler() {
		super();
	}

	public void acaoTelaInicial() {
		char opcao;
		do {
			opcao = preTela.telaInicial();
			switch (opcao) {
			// logar
			case '1':
				if (model.logar(dados.cnpj(), dados.senha()) == false) {
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

	public void telaProprietarioLogin() {
		char opcao;
		do {
			opcao = telaPro.menuLogin();
			switch (opcao) {
			//logar proprietario
			case '1':
				if (model.logar(dados.cnpj(), dados.senha()) == false) {
					notificacoes.msgUsuarioInvalido();
				} else {
					telaProprietario();
				}
				break;
				//cadastra proprietario
			case '2':
				if (model.cadastraProprieatrio(dados.nome(), dados.email(), dados.cnpj(), dados.telefone()) == true) {
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

	public void telaProprietario() {
		char opcao;
		do {
			opcao = menuPro.menuPropri();
			switch (opcao) {
			//visualizar lista
			case '1':
				notificacoes.Listausuarios(model.visualizaRestaurantes());
				break;
				//cadastro restaurante
			case '2':
				if(model.cadastroRestaurante(dRestaurante.nomeRestaurante(),dRestaurante.horarioFuncionamento(),dRestaurante.endereco(),dRestaurante.telefoneContato())==false) {
				notificacoes.msgRestauranteCad();}
				break;
			case '3':
				//não é aqui, remaneja essa chamada ao usuario
				notificacoes.ListaRestaurantes(model.listaRest());
				break;

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
				if(model.cadastroEnderecoAlternativo(endAlternativo.nomeDarua(), endAlternativo.NumCasa(), endAlternativo.nomeDoBairro(), endAlternativo.nomeMunicipio(), endAlternativo.nomeEstado())==false){
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
}
