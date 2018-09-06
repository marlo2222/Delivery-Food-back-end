package Negocios;

import java.util.ArrayList;

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
	private Proprietario usuario;

	public Model(Controler controler) {
		liUsuarios.adicionar(new Proprietario("marlo", "marlo@gmail.com", "06314815320", "92424095", 1234),
				"06314815320");
		this.controler = controler;
	}
	//cadastrando proprietarios
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
	//adicionando restaurante
	public boolean cadastroRestaurante(String nome, String horario, Endereco endereco, String contato) {
		Restaurantes restaurante = new Restaurantes();
		restaurante.setNome(nome);
		restaurante.setHorarioFucionamento(horario);
		restaurante.setLocalização(endereco);
		restaurante.setTelefoneContato(contato);
		// falta adicionar o restaurante na lista de restaurantes...
		if (usuario.restaurante == null) {
			usuario.restaurante = new ArrayList<Restaurantes>();
			usuario.restaurante.add(0, restaurante);
			return true;
		}
		if (usuario.restaurante.isEmpty() == true) {
			usuario.restaurante.add(restaurante);
			return true;
		}
		if (restauranteInexistente(usuario.restaurante, restaurante) == false) {
			usuario.restaurante.add(restaurante);
			return true;
		}
		return false;
	}
    //verificando existencia do restaurante
	private boolean restauranteInexistente(ArrayList<Restaurantes> restaurante, Restaurantes rest) {
		for (int i = 0; i < restaurante.size(); i++) {
			if (restaurante.get(i).getNome() == rest.getNome() && restaurante.get(i).getLocalização() == rest.getLocalização());
			return false;
		}
		return true;
	}
	//chamada para autenticação do usuario
	public boolean logar(String cpf, int senha) {
		Proprietario pro = liUsuarios.buscarSenha(cpf, senha);
		if (pro != null) {
			usuario = pro;
			return true;
		}
		return false;
	}
	//retorna uma lista de restaurantes
	public String visualizaRestaurantes() {
		String lista = "";
		if (usuario.restaurante == null || usuario.restaurante.isEmpty()) {
			return "Lista esta Vazia";
		}
		for (int i = 0; i < usuario.restaurante.size(); i++) {
			lista += 1 + i + "-" + usuario.restaurante.get(i).getNome()+"\n";
		}
		return lista;
	}
}