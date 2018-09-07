package Viem;

import java.util.Scanner;

import Negocios.Controler;
import Negocios.Model;

public class PreTela {
	public Model model;
	public Controler controler;
	Scanner input = new Scanner(System.in);
	
	public PreTela(Model model) {
		this.model = model;
		this.controler = new Controler(model,this);
		iniciar();
	}
	public void iniciar() {
		controler.acaoTelaInicial();
	}
	public char telaInicial() {
		System.out.println("1-logar");
		System.out.println("2-cadastrar");
		System.out.println("3-cadastre seu restaurante");
		System.out.println("4-sair");
		return(input.nextLine().charAt(0));
	}
}
