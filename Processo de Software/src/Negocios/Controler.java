package Negocios;

import Viem.PreTela;

public class Controler {
	public Model model;
	public PreTela preTela;

	public Controler(Model model, PreTela preTela){
		this.model = model;
		this.preTela = preTela;
	}
	
	public void acaoTelaInicial(char opcao) {
		do {
			switch (opcao) {
			
			case '1':
				model.cadastraProprieatrio();
				break;
			case '2':
				model.cadastraProprieatrio();
				break;
			default:
				break;}
			}while(opcao!='4');
	}
}
