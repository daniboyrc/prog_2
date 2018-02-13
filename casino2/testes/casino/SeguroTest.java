package casino;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import seguro.SeguroValor;
import seguro.SeguroTaxa;
import seguro.Seguro;

public class SeguroTest {
	private SeguroValor seguroValor;
	private SeguroTaxa seguroTaxa;
	private Seguro seguro;

	@Before
	public void seguroSimples() {
		this.seguroValor = new SeguroValor(10);
		this.seguroTaxa = new SeguroTaxa(0.1, 100);
	}
	
	/**
	 * Testa se cria seguro por valor com valores corretos.
	 */
	@Test
	public void testCriaSeguroValorSimples() {
		this.seguro = this.seguroValor;
	}
	
	/**
	 * Testa se cria seguro por valor com valor negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaSeguroValorMenorQueZero() {
		this.seguro = new SeguroValor(-1);
	}
	
	/**
	 * Testa se cria seguro por valor com valor igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaSeguroValorIgualZero() {
		this.seguro = new SeguroValor(0);
	}
	
	/**
	 * Verfica valor do seguro por valor.
	 */
	@Test
	public void testGetSeguroValor() {
		this.seguro = this.seguroValor;
		assertEquals(this.seguro.getValor(), 10);
	}
	
	/**
	 * Verifica representação em String do seguro por valor.
	 */
	@Test
	public void testToStringSeguroValor() {
		this.seguro = this.seguroValor;
		assertEquals("Strings não conferem", this.seguro.toString(), "ASSEGURADA (VALOR) - R$ 10,00");
	}
	
	/**
	 * Testa se cria seguro por taxa com valores corretos.
	 */
	@Test
	public void testCriaSeguroTaxaSimples() {
		this.seguro = this.seguroTaxa;
	}
	
	/**
	 * Testa se cria seguro por taxa com taxa negativa.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCricaSeguroTaxaMenorQueZero() {
		this.seguro = new SeguroTaxa(-0.1, 100);
	}
	
	/**
	 * Testa se cria seguro por taxa com taxa igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCricaSeguroTaxaIgualZero() {
		this.seguro = new SeguroTaxa(0, 100);
	}
	
	/**
	 * Verifica o valor do seguro por taxa.
	 */
	@Test
	public void testGetSeguroTaxa() {
		this.seguro = this.seguroTaxa;
		assertEquals(this.seguro.getValor(), 10);
	}
	
	/**
	 * Verifica a representação em String do seguro por taxa.
	 */
	@Test
	public void testToStringSeguroTaxa() {
		this.seguro = this.seguroTaxa;
		assertEquals("Strings não conferem", this.seguro.toString(), "ASSEGURADA (TAXA) - 10%");
	}
	
	

}	
	