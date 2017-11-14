import static org.junit.Assert.*;
import agenda.Telefone;

import org.junit.Before;
import org.junit.Test;

public class TelefoneTest {
	
	private Telefone telBasico;
	
	/**
	 * Cria um numero de telefone basico para testes.
	 */
	@Before
	public void criaTelefone() {
		this.telBasico = new Telefone("55", "83", "9169-4321", "CASA");
	}
	
	/**
	 * Testa se cria o telefone se receber o codigo de pais null.
	 */
	@Test
	public void testeCriaTelefoneCodPaisNulo() {
		try {
			this.telBasico = new Telefone(null, "83", "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o codgio de pais vazio.
	 */
	@Test
	public void testeCriaTelefoneCodPaisVazio() {
		try {
			this.telBasico = new Telefone("   ", "83", "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o ddd null.
	 */
	@Test
	public void testeCriaTelefoneDddNulo() {
		try {
			this.telBasico = new Telefone("55", null, "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o ddd vazio.
	 */
	@Test
	public void testeCriaTelefoneDddVazio() {
		try {
			this.telBasico = new Telefone("55", "  ", "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o numero null.
	 */
	@Test
	public void testeCriaTelefoneNumeroNulo() {
		try {
			this.telBasico = new Telefone("55", "83", null, "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o numero vazio.
	 */
	@Test
	public void testeCriaTelefoneNumeroVazio() {
		try {
			this.telBasico = new Telefone("55", "83", "   ", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o tipo de telefone null.
	 */
	@Test
	public void testeCriaTelefoneTipoNulo() {
		try {
			this.telBasico = new Telefone("55", "83", "9169-4321", null);
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se cria o telefone se receber o tipo de telefone vazio.
	 */
	@Test
	public void testeCriaTelefoneTipoVazio() {
		try {
			this.telBasico = new Telefone("55", "83", "9169-4321", "   ");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Testa se o metodo retorna a String esperada.
	 */
	@Test
	public void testeToString() {
		assertEquals("Strings diferentes", this.telBasico.toString(), "CASA: +55 (83) 9169-4321");
	}
}
