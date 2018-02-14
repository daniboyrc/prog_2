package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import casino.ControleSistema;

public class ControleSistemaTest {

	private ControleSistema cs = new ControleSistema();
	
	@Before
	public void InicializaSistema() {
		this.cs.inicializaSistema(1000, 0.1);
	}
	
	@Test
	public void testInicializaSistemaSimples() {
		this.cs.inicializaSistema(1000, 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInicializaCaixaNegativo() {
		this.cs.inicializaSistema(-1, 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInicializaCaixaTaxaIgualZero() {
		this.cs.inicializaSistema(1000, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInicializaCaixaTaxaNegativa() {
		this.cs.inicializaSistema(1000, -1);
	}
	
	@Test
	public void testCriaCenarioSimples() {
		this.cs.cadastraCenario("Não vai ter aula quarta");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCriaCenarioDescricaoNull() {
		this.cs.cadastraCenario(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioDescricaoVazia() {
		this.cs.cadastraCenario("   ");
	}
	
	@Test
	public void testCriaCenarioBonusSimples() {
		this.cs.cadastraCenario("Não vai ter aula quarta", 1000);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCriaCenarioBonusDescricaoNull() {
		this.cs.cadastraCenario(null, 1000);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioBonusDescricaoVazia() {
		this.cs.cadastraCenario("   ", 1000);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioBonusIgualZero() {
		this.cs.cadastraCenario("Não vai ter aula quarta", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioBonusNegativo() {
		this.cs.cadastraCenario("Não vai ter aula quarta", -1);
	}
	
	@Test
	public void testGetCenarioSimplesNaoFinalizado() {
		this.cs.cadastraCenario("Não vai ter aula quarta");
		String test = "1 - Não vai ter aula quarta - Nao finalizado";
		assertEquals(this.cs.getCenario(1), test);
	}

	@Test
	public void testGetCenarioSimplesFinalizado() {
		this.cs.cadastraCenario("Não vai ter aula quarta");
		this.cs.fecharAposta(1, false);
		String test = "1 - Não vai ter aula quarta - Finalizado";
		assertEquals(this.cs.getCenario(1), test);
	}
	
	@Test
	public void testGetCenarioBonusNaoFinalizado() {
		this.cs.cadastraCenario("Não vai ter aula quarta", 1000);
		String test = "1 - Não vai ter aula quarta - Nao finalizado - R$ 10,00";
		assertEquals(this.cs.getCenario(1), test);
	}
	
	@Test
	public void testGetCenarioBonusFinalizado() {
		this.cs.cadastraCenario("Não vai ter aula quarta", 1000);
		this.cs.fecharAposta(1, false);
		String test = "1 - Não vai ter aula quarta - Finalizado - R$ 10,00";
		assertEquals(this.cs.getCenario(1), test);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
