package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import casino.Casino;

public class CasinoTest {

	private Casino casino;

	@Before
	public void cadastraApostaTeste() {
		this.casino = new Casino(10, 10.0);
	}
	
	@Test
	public void testCadastraApostaSimples() {
		this.casino = new Casino(10, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCasinoCaixaMenorQueZero() {
		this.casino = new Casino(-1, 10);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCasinoPorcentagemMenorQueZero() {
		this.casino = new Casino(1, -1);
	}
	
	@Test
	public void testSomaCaixa() {
		this.casino.somaCaixa(10);
		assertEquals(20, this.casino.getCaixa());
	}
	
	@Test
	public void testToString() {
		assertEquals("10 - 10.0", this.casino.toString());
	}	
	
}
