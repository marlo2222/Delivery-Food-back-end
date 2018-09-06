package Negocios;

import EsDadosTemp.Hash;
import Verificacoes.AutenticarDados;
import Viem.ViemDadosRestaurante;
import Viem.ViemDadoscadastro;
import Viem.ViemNotificacoes;
import Viem.ViemPropritario;

public class Model {
	private AutenticarDados autenticacao = new AutenticarDados();
	private Hash liUsuarios = new Hash();
	private Controler controler;
	private Object usuario;

	public Model(Controler controler) {
		liUsuarios.adicionar(new Proprietario("marlo", "marlo@gmail.com", "06314815320", "92424095", 1234),
				"06314815320");
		this.controler = controler;
	}

	public boolean cadastraProprieatrio(String nome, String email, String cpf, String telefone) {

		Proprietario proprietario = new Proprietario();
		
		proprietario.setNomeProprietario(nome);
		proprietario.setEmailProprietario(email);
		proprietario.setCpf(cpf);
		proprietario.setContatoProprietario(telefone);

		if (liUsuarios.buscar(proprietario.getCpf(), proprietario.getNomeProprietario()) == true) {
			if (autenticacao.AutenticarDados(proprietario) == true) {
				proprietario.setSenha(controler.definirSenha());
				liUsuarios.adicionar(proprietario, proprietario.getCpf());
				return true;
			}
		}
		return false;
	}

	public void cadastroRestaurante(String nome, String horario, Endereco endereco, String contato) {
		Restaurantes restaurante = new Restaurantes();
		restaurante.setNome(nome);
		restaurante.setHorarioFucionamento(horario);
		restaurante.setLocalização(endereco);
		restaurante.setTelefoneContato(contato);
		//falta adicionar o restaurante na lista de restaurantes...

	}

	public boolean logar(String cpf, int senha) {
		Proprietario pro = liUsuarios.buscarSenha(cpf, senha);
		if (pro != null) {
			usuario = pro;
			return true;
		}
		return false;
	}

}