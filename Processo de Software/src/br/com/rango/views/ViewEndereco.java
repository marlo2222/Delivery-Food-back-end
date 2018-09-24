package br.com.rango.views;

import java.util.Scanner;

public class ViewEndereco {
	Scanner input = new Scanner(System.in);

	public void mgsEnderecoDeEntregaErro() {
		System.out.println("O endereço informado não faz parte da zona de serviços do RangoRussas ");
	}

	public void msgEnderecoDeEntregaConfirmado() {
		System.out.println("Endereço de entrega salvo com sucesso");
	}

	public void msgEnderecoDeCadastro() {
		System.out.println("Endereço de entrega confirmado");
	}

	public String nomeDarua() {
		System.out.println("Informe o nome da rua:");
		return input.nextLine();
	}

	public String NumCasa() {
		System.out.println("informe o numero da casa:");
		return input.nextLine();
	}

	public String nomeDoBairro() {
		System.out.println("informe seu bairro:");
		return input.nextLine();
	}

	public String nomeMunicipio() {
		System.out.println("informe seu municipio:");
		return input.nextLine();
	}

	public String nomeEstado() {
		System.out.println("informe seu estado:");
		return input.nextLine();
	}
}
