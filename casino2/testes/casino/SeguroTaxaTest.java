package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguroTaxaTest {
	private SeguroTaxa seguro;

	@Before
	public void criaSeguroSimples() {
		this.seguro = new SeguroTaxa(0.1, 100);
	}

	/**
	 * Testa se cria o seguro com valores corretos.
	 */
	@Test
	public void testCriaSeguroSimples() {
		this.seguro = new SeguroTaxa(0.1, 100);
	}
	
	/**
	 * Testa se cria o seguro com taxa negativa.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaSeguroTaxaMenorQueZero() {
		this.seguro = new SeguroTaxa(-0.1, 100);
	}
	
	/**
	 * Testa se cria o seguro com taxa igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaSeguroTaxaIgualZero() {
		this.seguro = new SeguroTaxa(0, 10);
	}
	
	/**
	 * Verifica o valor do seguro.
	 */
	@Test
	public void testGetValor() {
		assertEquals(this.seguro.getValor(), 10);
	}
	
	/**
	 * Verifica representação em String do seguro
	 */
	@Test()
	public void testToString() {
		assertEquals("Strings não conferem", this.seguro.toString(), "ASSEGURADA (TAXA) - 10%");
	}

}	
	