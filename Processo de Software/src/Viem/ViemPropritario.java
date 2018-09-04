package Viem;

import java.util.Scanner;

import Negocios.Controler;

public class ViemPropritario {
	public void telaPro() {
		Controler control = new Controler();
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
