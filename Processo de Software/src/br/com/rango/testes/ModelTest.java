package br.com.rango.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rango.model.Model;
import static junit.framework.Assert.*;

class ModelTest {
Model model;
	@BeforeEach
	void setUp() throws Exception {
	model = new Model();
	}


	@Test
	void testCadastraProprieatrio() {
		assertEquals(true , model.cadastraProprieatrio("maria", "maria@gmail.com", "07319817320", "94445320"));;
	}

	/*@Test
	void testCadastraUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testCadastroRestaurante() {
		fail("Not yet implemented");
	}

	@Test
	void testListaRest() {
		fail("Not yet implemented");
	}

	@Test
	void testVisualizaRestaurantes() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarRestIntString() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarRestIntEndereco() {
		fail("Not yet implemented");
	}

	@Test
	void testDefinirRestaurantePadrao() {
		fail("Not yet implemented");
	}

	@Test
	void testRevomerRestaurante() {
		fail("Not yet implemented");
	}

	@Test
	void testLogarProprietario() {
		fail("Not yet implemented");
	}

	@Test
	void testLogarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testDefinirEnderecoPadrao() {
		fail("Not yet implemented");
	}

	@Test
	void testListaEnderecosUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testModificarEnderecoPadrao() {
		fail("Not yet implemented");
	}

	@Test
	void testAdicionarEndereco() {
		fail("Not yet implemented");
	}

	@Test
	void testEnderecoInexistente() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testCadastraPrato() {
		fail("Not yet implemented");
	}

	@Test
	void testPratoJaCadastrado() {
		fail("Not yet implemented");
	}

	@Test
	void testLiPratos() {
		fail("Not yet implemented");
	}
*/
}
