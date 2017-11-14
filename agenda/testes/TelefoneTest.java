import static org.junit.Assert.*;
import agenda.Telefone;

import org.junit.Before;
import org.junit.Test;

public class TelefoneTest {
	
	private Telefone telBasico;
	
	@Before
	public void criaTelefone() {
		this.telBasico = new Telefone("55", "83", "9169-4321", "CASA");
	}
	
	@Test
	public void testeCriaTelefoneComum() {
		this.telBasico = new Telefone("55", "83", "9169-4321", "CASA");
	}
	
	@Test
	public void testeCriaTelefoneCodPaisNulo() {
		try {
			this.telBasico = new Telefone(null, "83", "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneCodPaisVazio() {
		try {
			this.telBasico = new Telefone("   ", "83", "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneDddNulo() {
		try {
			this.telBasico = new Telefone("55", null, "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneDddVazio() {
		try {
			this.telBasico = new Telefone("55", "  ", "9169-4321", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneNumeroNulo() {
		try {
			this.telBasico = new Telefone("55", "83", null, "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneNumeroVazio() {
		try {
			this.telBasico = new Telefone("55", "83", "   ", "CASA");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneTipoNulo() {
		try {
			this.telBasico = new Telefone("55", "83", "9169-4321", null);
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeCriaTelefoneTipoVazio() {
		try {
			this.telBasico = new Telefone("55", "83", "9169-4321", "   ");
			fail("Era esperada uma excessão");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testeToString() {
		assertEquals("Strings não corespondem", this.telBasico.toString(), "CASA: +55 (83) 9169-4321");
	}
}
