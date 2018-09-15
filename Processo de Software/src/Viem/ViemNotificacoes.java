package Viem;

import java.util.Scanner;

public class ViemNotificacoes {
	Scanner input = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	public void mgsUsuarioExistente() {
		System.out.println("Usuario ja cadastrado no sistema");
	}
	public void mgsUsuarioCadastrado() {
		System.out.println("Usuario Cadastrado com sucesso");
	}
	public void msgUsuarioInvalido() {
		System.out.println("usuario invalido");
	}
	public void msgRestauranteCad() {
		System.out.println("Nao foi possivel cadastra o restaurante.\n estabelecimento já cadastrado no sistema");
	}
	public void Listausuarios(String lista){
		System.out.println(lista);
		
	}
	public void ListaRestaurantes(String lista) {
		System.out.println(lista);
	}
	public void msgRemoverRestaurante(String msg) {
		System.out.println(msg);
	}
	public int Lista(String lista) {
		System.out.println("Escolha o restaurante que deseja excluir:");
		System.out.println(lista);
		return inputInt.nextInt();
	}
	public void notificacao(String msg) {
		System.out.println(msg);
	}
}
