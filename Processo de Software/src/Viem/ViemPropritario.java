package Viem;

import java.util.Scanner;

import Negocios.Model;

public class ViemPropritario {
	public void telaPro() {
		Model control = new Model();
		Scanner input = new Scanner(System.in);
		System.out.println("cadastra restaurante");
		System.out.println();
		char op  = input.next().charAt(0);
		switch (op) {
		case '1':
			control.cadastroRestaurante();
			break;

		default:
			break;
		}
	}

}
