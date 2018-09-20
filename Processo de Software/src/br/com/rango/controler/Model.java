package br.com.rango.controler;

import java.util.ArrayList;

import br.com.rango.estruturasdados.Hash;
import br.com.rango.estruturasdados.NoHash;
import br.com.rango.verificacoes.AutenticarDados;
import br.com.rango.viens.TelaPrincipalProprietario;
import br.com.rango.viens.ViemDadosRestaurante;
import br.com.rango.viens.ViemDadoscadastro;
import br.com.rango.viens.ViemNotificacoes;

public class Model {
	private AutenticarDados autenticacao = new AutenticarDados();
	private Hash liUsuarios = new Hash();
	private Controler controler;
	private Proprietario usuario;
	private Hash liRestaurantes = new Hash();

	public Model(Controler controler) {
		liUsuarios.adicionar(new Proprietario("marlo", "marlo@gmail.com", "06314815320", "92424095", 1234),
				"06314815320");
		liUsuarios.adicionar(new Proprietario("maria", "maria@gmail.com", "09876543212", "92424095", 1234),
				"09876543212");
		this.controler = controler;
	}

	// retornando um lista de restaurantes para o usuario
	public String listaRest() {
		int cont = 1;
		String lista = "";
		for (int indice = 0; indice < liUsuarios.length(); indice++) {
			if (liUsuarios.hash[indice] != null) {
				for (NoHash aux = liUsuarios.hash[indice].inicio; aux != null; aux = aux.prox) {
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

		Proprietario proprietario = new Proprietario();

		proprietario.setNome(nome);
		proprietario.setEmail(email);
		proprietario.setCpf(cpf);
		proprietario.setContato(telefone);

		if (liUsuarios.buscar(proprietario.getCpf(), proprietario.getNome()) == true) {
			if (autenticacao.AutenticarDados(proprietario) == true) {
				proprietario.setSenha(controler.definirSenha());
				liUsuarios.adicionar(proprietario, proprietario.getCpf());
				return true;
			}
		}
		return false;
	}

	// adicionando restaurante
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
	public boolean logar(String cpf, int senha) {
		Proprietario pro = liUsuarios.buscarSenha(cpf, senha);
		if (pro != null) {
			usuario = pro;
			return true;
		}
		return false;
	}

	// retorna uma lista de restaurantes
	public String visualizaRestaurantes() {
		String lista = "";
		if (usuario.restaurante == null || usuario.restaurante.isEmpty()) {
			return "Lista esta Vazia";
		}
		for (int i = 0; i < usuario.restaurante.size(); i++) {
			lista += 1 + i + "-" + usuario.restaurante.get(i).getNome() + "\n";
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
	
	
	


	public String revomerRestaurante(int indice) {
		if (usuario.restaurante != null) {
			if (!usuario.restaurante.isEmpty()) {
				if (controler.definirSenha() == usuario.getSenha() && indice <= usuario.restaurante.size()) {
					usuario.restaurante.remove(indice - 1);
					return "restaurante removido com sucesso";

				}
			}
		}
		return "não foi possivel remover o restaurante";
	}

	public void AtualizarRest(int posicao, String informacao) {
		if(posicao == 1)
			usuario.restaurante.get(posicao-1).setNome(informacao);
		if(posicao == 2)
			usuario.restaurante.get(posicao-1).setHorarioFucionamento(informacao);
		if(posicao == 4)
			usuario.restaurante.get(posicao-1).setTelefoneContato(informacao);
	}

	public void AtualizarRest(int posicao,Endereco endereco) {
		usuario.restaurante.get(posicao-1).setLocalização(endereco);
	}

}