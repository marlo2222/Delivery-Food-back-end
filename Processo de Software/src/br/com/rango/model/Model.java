package br.com.rango.model;

import java.util.ArrayList;

import br.com.rango.controller.ControllerTelaInicial;
import br.com.rango.estruturasdados.restaurante.*;
import br.com.rango.estruturasdados.usuario.*;
import br.com.rango.verificacoes.AutenticarDados;


public class Model {
	private AutenticarDados autenticacao = new AutenticarDados();
	private Hash liProprietario = new Hash();
	private ControllerTelaInicial controler;
	private Proprietario proprietario;
	private Usuario usuario;
	private Hash liRestaurantes = new Hash();
	private HashU liUsuario = new HashU();

	public Model(ControllerTelaInicial controler) {
		liProprietario.adicionar(new Proprietario("marlo", "marlo@gmail.com", "06314815320", "92424095", 1234),
				"06314815320");
		liProprietario.adicionar(new Proprietario("maria", "maria@gmail.com", "09876543212", "92424095", 1234),
				"09876543212");
		this.controler = controler;
	}

	// retornando um lista de restaurantes para o usuario
	public String listaRest() {
		int cont = 1;
		String lista = "";
		for (int indice = 0; indice < liProprietario.length(); indice++) {
			if (liProprietario.hash[indice] != null) {
				for (NoHash aux = liProprietario.hash[indice].inicio; aux != null; aux = aux.prox) {
					ArrayList<Restaurantes> rest = aux.proprietario.restaurante;
					if (rest != null) {
						for (int i = 0; i < rest.size(); i++) {
							lista += (cont++) + "->" + rest.get(i).getNome() + "\n";
						}
					}
				}

			}
		}
		return lista;
	}

	// cadastrando proprietarios
	public boolean cadastraProprieatrio(String nome, String email, String cpf, String telefone) {

		Proprietario proprietario = new Proprietario(nome, email, cpf, telefone);

		if (liProprietario.buscar(proprietario.getCpf(), proprietario.getNome()) == true) {
			if (autenticacao.AutenticarDados(proprietario) == true) {
				proprietario.setSenha(controler.definirSenha());
				liProprietario.adicionar(proprietario, proprietario.getCpf());
				return true;
			}
		}
		return false;
	}
	//cadastro usuario
	public boolean cadastraUsuario(String nome, String email, String cpf, String telefone) {

		Usuario usuario = new Usuario(nome, email, cpf, telefone);

		if (liUsuario.buscar(usuario.getCpf(), usuario.getNome()) == true) {
			if (autenticacao.AutenticarDados(usuario) == true) {
				usuario.setSenha(controler.definirSenha());
				liUsuario.adicionar(usuario, usuario.getCpf());
				return true;
			}
		}
		return false;
	}

	// adicionando restaurante
	public boolean cadastroRestaurante(String nome, String horario, Endereco endereco, String contato) {
		Restaurantes restaurante = new Restaurantes(nome, horario, endereco, contato);
	
		if (proprietario.restaurante == null) {
			proprietario.restaurante = new ArrayList<Restaurantes>();
			proprietario.restaurante.add(0, restaurante);
			return true;
		}
		if (proprietario.restaurante.isEmpty() == true) {
			proprietario.restaurante.add(restaurante);
			return true;
		}
		if (restauranteInexistente(proprietario.restaurante, restaurante) == false) {
			proprietario.restaurante.add(restaurante);
			return true;
		}
		return false;
	}

	// verificando existencia do restaurante
	private boolean restauranteInexistente(ArrayList<Restaurantes> restaurante, Restaurantes rest) {
		for (int i = 0; i < restaurante.size(); i++) {
			if (restaurante.get(i).getNome() == rest.getNome()
					&& restaurante.get(i).getLocalização() == rest.getLocalização())
				;
			return false;
		}
		return true;
	}

	// chamada para autenticação do usuario
	public boolean logarProprietario(String cpf, int senha) {
		Proprietario pro = liProprietario.buscarSenha(cpf, senha);
		if (pro != null) {
			proprietario = pro;
			return true;
		}
		return false;
	}

	// chamada para autenticação do usuario
	public boolean logarUsuario(String cpf, int senha) {
		Usuario user = liUsuario.buscarSenha(cpf, senha);
		if (user != null) {
			usuario = user;
			return true;
		}
		return false;
	}


	// retorna uma lista de restaurantes
	public String visualizaRestaurantes() {
		String lista = "";
		if (proprietario.restaurante == null || proprietario.restaurante.isEmpty()) {
			return "Lista esta Vazia";
		}
		for (int i = 0; i < proprietario.restaurante.size(); i++) {
			lista += 1 + i + "-" + proprietario.restaurante.get(i).getNome() + "\n";
		}
		return lista;
	}

	//não estou conseguindo pensar em como validar sem ser pelo set essas strings, por isso ira retornar true por enquanto
	//endereco alternativo
	public boolean cadastroEnderecoAlternativo(String nomeDarua, String numCasa, String nomeDoBairro, String nomeMunicipio, String nomeEstado) {
		Endereco endAux = new Endereco();
		endAux.setRua(nomeDarua);
		endAux.setNumero(numCasa);
		endAux.setBairro(nomeDoBairro);
		endAux.setMunicipio(nomeMunicipio);
		endAux.setEstado(nomeEstado);
		return true;
	}
	
	public boolean revomerRestaurante(int indice) {
		if (proprietario.restaurante != null) {
			if (!proprietario.restaurante.isEmpty()) {
				if (controler.definirSenha() == proprietario.getSenha() && indice <= proprietario.restaurante.size()) {
					proprietario.restaurante.remove(indice - 1);
					return true;

				}
			}
		}
		return false;
	}

	public void AtualizarRest(int posicao, String informacao) {
		if(posicao == 1)
			proprietario.restaurante.get(posicao-1).setNome(informacao);
		if(posicao == 2)
			proprietario.restaurante.get(posicao-1).setHorarioFucionamento(informacao);
		if(posicao == 4)
			proprietario.restaurante.get(posicao-1).setTelefoneContato(informacao);
	}

	public void AtualizarRest(int posicao,Endereco endereco) {
		proprietario.restaurante.get(posicao-1).setLocalização(endereco);
	}

}