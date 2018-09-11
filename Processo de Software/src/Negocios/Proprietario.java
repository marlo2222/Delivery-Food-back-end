package Negocios;

import java.util.ArrayList;

public class Proprietario extends Usuario {
	public ArrayList<Restaurantes> restaurante;
	
	public Proprietario(String nome,String email, String cpf,String contato,int senha) {
		setNome(nome);
		setEmail(email);
		setCpf(cpf);
		setContato(contato);
		setSenha(senha);
		
	}
	
	public Proprietario() {
		super();
	}

	public ArrayList<Restaurantes> getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(ArrayList<Restaurantes> restaurante) {
		this.restaurante = restaurante;
	}
	
	public void setRestaurante(Restaurantes restaurantes) {
		// TODO Auto-generated method stub
		
	}


}
