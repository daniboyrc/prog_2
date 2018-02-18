package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import casino.Casino;

public class CasinoTest {

	private Casino casino;

	/**
	 * Cria um casino simples para testes.
	 */
	@Before
	public void cadastraApostaTeste() {
		this.casino = new Casino(10, 10.0);
	}
	
	/**
	 * Testa se cadastra casino simples.
	 */
	@Test
	public void testCadastraApostaSimples() {
		this.casino = new Casino(10, 10);
	}
	
	/**
	 * Testa se cadastra casino com caixa negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCasinoCaixaMenorQueZero() {
		this.casino = new Casino(-1, 10);
	}
	
	/**
	 * Testa se cadastra casino com taxa negativa.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraCasinoPorcentagemMenorQueZero() {
		this.casino = new Casino(1, -1);
	}
	
	/**
	 * Testa a soma do caixa do casino.
	 */
	@Test
	public void testSomaCaixa() {
		this.casino.somaCaixa(10);
		assertEquals(20, this.casino.getCaixa());
	}
	
	/**
	 * Testa a soma do caixa do casino.
	 */
	@Test
	public void testRetiraCaixa() {
		this.casino.retiraCaixa(10);
		assertEquals(0, this.casino.getCaixa());
	}
	
	/**
	 * Testa a representação em String do casino.
	 */
	@Test
	public void testToString() {
		assertEquals("10 - 10.0", this.casino.toString());
	}	
	
}
