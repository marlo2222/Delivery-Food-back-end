package Viem;

public class ViemNotificacoes {
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
}
