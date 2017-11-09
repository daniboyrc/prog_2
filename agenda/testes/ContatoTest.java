import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import agenda.Contato;

public class ContatoTest {
		
	private Contato contatoBasico;

	@Before
	public void criaContato() {
		this.contatoBasico = new Contato("Daniel", "Rodrigues", "(83)99169-3620");
    }
	
	@Test
	public void testeContatoNomeNull() {
		try {
			this.contatoBasico = new Contato(null, "Rodrigues", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	public void testeContatoNomeInvalido() {
		try {
			this.contatoBasico = new Contato("", "Rodrigues", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testeContatoSobrenomeNull() {
		try {
			this.contatoBasico = new Contato("Daniel", null, "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	public void testeContatoSobrenomeInvalido() {
		try {
			this.contatoBasico = new Contato("Daniel", "", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testeContatoTelefoneNull() {
		try {
			this.contatoBasico = new Contato("Daniel", "Rodrigues", null);
			fail("Era esperada uma excessão");
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	public void testeContatoTelefoneInvalido() {
		try {
			this.contatoBasico = new Contato("Daniel", "Rodrigues", "");
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testeToString() {
		assertEquals("Strings diferentes", this.contatoBasico.toString(), "Daniel Rodrigues - (83)99169-3620");
	}
}
