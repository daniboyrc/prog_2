package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import casino.Aposta;

public class ApostaTest {

	private Aposta apostaSimples;

	/**
	 * Cria uma aposta simples para testes.
	 */
	@Before
	public void cadastraApostaSimples() {
		this.apostaSimples = new Aposta("daniel", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com os valores corretos.
	 */
	@Test
	public void testCadastraApostaSimples() {
		this.apostaSimples = new Aposta("daniel", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com o nome do apostador nulo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeNull() {
		this.apostaSimples = new Aposta(null, 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com o nome do apostador vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeVazio() {
		this.apostaSimples = new Aposta("  ", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com o valor apostado igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorZero() {
		this.apostaSimples = new Aposta("daniel", 0, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com o valor apostado negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorMenorQueZero() {
		this.apostaSimples = new Aposta("daniel", -4, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com a previsão nula.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoNull() {
		this.apostaSimples = new Aposta("daniel", 10, null);
	}
	
	/**
	 * Testa se cria aposta com a previsão vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.apostaSimples = new Aposta("daniel", 10, "    ");
	}
	
	/**
	 * Testa se cria aposta com a previsão "N VAI ACONTECER".
	 */
	@Test
	public void testCadastraApostaPrevisaoNaoVaiAcontecer() {
		this.apostaSimples = new Aposta("daniel", 10, "N VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com a previsão "VAI ACONTECER".
	 */
	@Test
	public void testCadastraApostaPrevisaoVaiAcontecer() {
		this.apostaSimples = new Aposta("daniel", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria aposta com a previsão errada
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoInvalida() {
		this.apostaSimples = new Aposta("daniel", 10, "ALGUMA COISA");
	}
	
	/**
	 * Testa se cria aposta com a previsão "N VAI ACONTECER".
	 */
	@Test
	public void testGetPrevisaoTrue() {
		assertTrue(this.apostaSimples.getPrevisao());
	}
	
	/**
	 * Testa a conversão de String para booleano da previsão.
	 */
	@Test
	public void testGetPrevisaoFalse() {
		this.apostaSimples = new Aposta("daniel", 10, "N VAI ACONTECER");
		assertFalse(this.apostaSimples.getPrevisao());
	}
	
	/**
	 * Testa a representação em String da aposta.
	 */
	@Test
	public void testToString() {
		this.apostaSimples = new Aposta("daniel", 10, "N VAI ACONTECER");
		assertEquals("Strings diferentes", "daniel - 10 - N VAI ACONTECER", this.apostaSimples.toString());
	}

}
