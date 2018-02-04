package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import casino.Aposta;

public class ApostaTest {

	private Aposta apostaSimples;

	@Before
	public void cadastraApostaSimples() {
		this.apostaSimples = new Aposta("daniel", 10, "VAI ACONTECER");
	}
	
	@Test
	public void testCadastraApostaSimples() {
		this.apostaSimples = new Aposta("daniel", 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeNull() {
		this.apostaSimples = new Aposta(null, 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeVazio() {
		this.apostaSimples = new Aposta("  ", 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoNull() {
		this.apostaSimples = new Aposta("daniel", 10, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.apostaSimples = new Aposta("daniel", 10, "    ");
	}
	
	@Test
	public void testCadastraApostaPrevisaoNaoVaiAcontecer() {
		this.apostaSimples = new Aposta("daniel", 10, "N VAI ACONTECER");
	}
	
	@Test
	public void testCadastraApostaPrevisaoVaiAcontecer() {
		this.apostaSimples = new Aposta("daniel", 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoInvalida() {
		this.apostaSimples = new Aposta("daniel", 10, "ALGUMA COISA");
	}
	
	@Test
	public void testGetPrevisaoTrue() {
		assertTrue(this.apostaSimples.getPrevisao());
	}
	
	@Test
	public void testGetPrevisaoFalse() {
		this.apostaSimples = new Aposta("daniel", 10, "N VAI ACONTECER");
		assertFalse(this.apostaSimples.getPrevisao());
	}
	
	@Test
	public void testToString() {
		this.apostaSimples = new Aposta("daniel", 10, "N VAI ACONTECER");
		assertEquals("Strings diferentes", "daniel - 10 - N VAI ACONTECER", this.apostaSimples.toString());
	}

}
