package Verificacoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Viem.ViemValidacao;

public class AutenticarDados {
	ViemValidacao viem = new ViemValidacao();

	public boolean verificarEmail(String email) {

		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); // expreção reguralar com o formato de um email valido
		Matcher m = p.matcher(email);
		if (m.find()) {
			viem.msgEmailValido();
			return true;
		} else {
			viem.msgEmailInvalido();
			return false;
		}
	}
	 public boolean verificaCNPJ(String CNPJ) {
		    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
		        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
		        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") || (CNPJ.length() != 14)) {
		    	viem.msgCnpjInvalido();
		       return(false);}
		 
		    char dig13, dig14;
		    int sm, i, r, num, peso;
		    
		// Calculo do 1o. Digito Verificador
		      sm = 0;
		      peso = 2;
		      for (i=11; i>=0; i--) {
		        num = (int)(CNPJ.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10)
		           peso = 2;
		      }
		 
		      r = sm % 11;
		      if ((r == 0) || (r == 1))
		         dig13 = '0';
		      else dig13 = (char)((11-r) + 48);
		 
		// Calculo do 2o. Digito Verificador
		      sm = 0;
		      peso = 2;
		      for (i=12; i>=0; i--) {
		        num = (int)(CNPJ.charAt(i)- 48);
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10)
		           peso = 2;
		      }
		 
		      r = sm % 11;
		      if ((r == 0) || (r == 1))
		         dig14 = '0';
		      else dig14 = (char)((11-r) + 48);
		 
		// Verifica se os dígitos calculados conferem com os dígitos informados.
		      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
		         viem.msgCnpjValido();
		    	  return(true);}
		      else {
		    	  viem.msgCnpjInvalido();
		    	  return(false);}
		      
		    
		  }

}
