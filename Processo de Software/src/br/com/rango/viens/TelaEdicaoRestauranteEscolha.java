package br.com.rango.viens;

import java.util.Scanner;

public class TelaEdicaoRestauranteEscolha {
	Scanner input = new Scanner(System.in);
	public int selecionarRestEdicao(String lista) {
		System.out.println("Escolha o restaurante que deseja editar:");
		System.out.println(lista);
		return input.nextInt(); 
	}
	public int campoParaModificar() {
		System.out.println("Qual informação do restaurante deseja modificar:");
		System.out.println("1 -> Nome");
		System.out.println("2 -> Horario Funcionamento");
		System.out.println("3 -> Endereço");
		System.out.println("4 -> Telefone");
		return input.nextInt();
	}

}
