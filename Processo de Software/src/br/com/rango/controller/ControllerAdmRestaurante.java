package br.com.rango.controller;

import br.com.rango.model.*;
import br.com.rango.views.*;

public class ControllerAdmRestaurante {
	public Model model;
	public ViemAdmRestaurante admRestaurante;

	public ControllerAdmRestaurante(Model model) {
		this.model = model;
	}

	public void AdmRestaurante() {
		char opcao;
		do {
			opcao = admRestaurante.telaAdmRestaurante();
			switch (opcao) {
			case '1':

				break;
			case '2':

				break;
			case '3':

				break;
			default:
				break;
			}
		} while (opcao != '4');
	}

}
