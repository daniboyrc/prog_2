package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seguro.SeguroValor;

public class SeguroValorTest {
	private SeguroValor seguro;

	@Before
	public void criaSeguroSimples() {
		this.seguro = new SeguroValor(10);
	}
	
	/**
	 * Testa se cria seguro com valores corretos.
	 */
	@Test
	public void testCriaSeguroSimples() {
		this.seguro = new SeguroValor(10);
	}
	
	/**
	 * Testa se cria seguro com valor negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaSeguroMenorQueZero() {
		this.seguro = new SeguroValor(-1);
	}
	
	/**
	 * Testa se cria seguro com valor igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaSeguroIgualZero() {
		this.seguro = new SeguroValor(0);
	}

	/**
	 * Verifica o valor do seguro.
	 */
	@Test
	public void testGetValor() {
		assertEquals(this.seguro.getValor(), 10);
	}
	
	/**
	 * Verifica a representação em String do seguro.
	 */
	@Test()
	public void testToString() {
		assertEquals("Strings não conferem", this.seguro.toString(), "ASSEGURADA (VALOR) - R$ 10,00");
	}

}	
	