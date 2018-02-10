package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import casino.Cenario;

public class CenarioTest {

public Cenario cenario;
	
	@Before
	public void cenarioTeste() {
		this.cenario = new Cenario("vai ganhar", 1);
	}
	
	@Test
	public void testCriaCenarioSimples() {
		this.cenario = new Cenario("vai ganhar", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioNomeNulo() {
		this.cenario = new Cenario(null, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioNomeVazio() {
		this.cenario = new Cenario("  ", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioIdZero() {
		this.cenario = new Cenario("vai ganhar", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioIdMenorQueZero() {
		this.cenario = new Cenario("vai ganhar", -4);
	}


}
