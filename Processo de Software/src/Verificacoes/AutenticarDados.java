package Verificacoes;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Negocios.Proprietario;
import Viem.ViemValidacao;

public class AutenticarDados {
	ViemValidacao viem = new ViemValidacao();

	public void AutenticarDadosProprietario(Proprietario prop) {
		verificarEmail(prop.getEmailProprietario());
		verificarNome(prop.getNomeProprietario());
		verificarTelefone(prop.getContatoProprietario());
		verificarCPF(prop.getCpf());
	}

	private boolean verificarEmail(String email) {

		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		if (m.find())
			return true;
		viem.msgEmailInvalido();
		return false;

	}

	private boolean verificarNome(String nome) {
		if (nome != null && nome.length() > 3)
			return true;
		viem.nomeInvalido();
		return false;
	}

	private boolean verificarTelefone(String telefone) {
		if (telefone != null && telefone.length() == 8)
			return true;
		viem.msgTelefoneInvalido();
		return false;
	}

	public boolean verificarCPF(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			viem.msgCpfInvalido();
			return (false);}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
				viem.msgCpfInvalido();
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
