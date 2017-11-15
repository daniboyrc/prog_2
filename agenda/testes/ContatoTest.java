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
	 * Testa se cria o contato ao receber o nome null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testeContatoNomeNull() {
		this.contatoBasico = new Contato(null, "Rodrigues", "(83)99169-3620");
	}
	
	/**
	 * Testa se cria o contato ao receber o nome somente com espacos.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testeContatoNomeInvalido() {
		this.contatoBasico = new Contato("   ", "Rodrigues", "(83)99169-3620");
	}
	
	/**
	 * Testa se cria o contato ao receber o sobrenome null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testeContatoSobrenomeNull() {
		this.contatoBasico = new Contato("Daniel", null, "(83)99169-3620");
	}
	
	/**
	 * Testa se cria o contato ao receber o sobrenome nome somente com espacos.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testeContatoSobrenomeInvalido() {
		this.contatoBasico = new Contato("Daniel", "   ", "(83)99169-3620");
	}
	
	/**
	 * Testa se cria o contato ao receber o telefone null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testeContatoTelefoneNull() {
		this.contatoBasico = new Contato("Daniel", "Rodrigues", null);
	}
	
	/**
	 * Testa se cria o contato ao receber o telefone nome somente com espacos.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testeContatoTelefoneInvalido() {
		this.contatoBasico = new Contato("Daniel", "Rodrigues", "   ");
	}
	
	/**
	 * Testa se o metodo retorna a String esperada.
	 */
	@Test
	public void testeToString() {
		assertEquals("Strings diferentes", this.contatoBasico.toString(), "Daniel Rodrigues - (83)99169-3620");
	}
}
