import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import agenda.Contato;

public class ContatoTest {
		
	private Contato contatoBasico;

	/**
	 * Cria um contato basico para testes.
	 */
	@Before
	public void criaContato() {
		this.contatoBasico = new Contato("Daniel", "Rodrigues", "(83)99169-3620");
    }
	
	/**
	 * Testa se cria o contato se receber o nome null.
	 */
	@Test
	public void testeContatoNomeNull() {
		try {
			this.contatoBasico = new Contato(null, "Rodrigues", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se cria o contato se receber o nome como String vazia.
	 */
	public void testeContatoNomeInvalido() {
		try {
			this.contatoBasico = new Contato("", "Rodrigues", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se cria o contato se receber o sobrenome null.
	 */
	@Test
	public void testeContatoSobrenomeNull() {
		try {
			this.contatoBasico = new Contato("Daniel", null, "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se cria o contato se receber o nome como String vazia.
	 */
	public void testeContatoSobrenomeInvalido() {
		try {
			this.contatoBasico = new Contato("Daniel", "", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se cria o contato se receber o telefone null.
	 */
	@Test
	public void testeContatoTelefoneNull() {
		try {
			this.contatoBasico = new Contato("Daniel", "Rodrigues", null);
			fail("Era esperada uma excessão");
		} catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se cria o contato se receber o telefone como String vazia.
	 */
	public void testeContatoTelefoneInvalido() {
		try {
			this.contatoBasico = new Contato("Daniel", "Rodrigues", "");
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se o metodo retorna a String esperada.
	 */
	@Test
	public void testeToString() {
		assertEquals("Strings diferentes", this.contatoBasico.toString(), "Daniel Rodrigues - (83)99169-3620");
	}
}
