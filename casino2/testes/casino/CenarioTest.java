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
		this.cenario.cadastraAposta("daniel", 10, "VAI ACONTECER");
		this.cenario.cadastraAposta("daniel", 15, "N VAI ACONTECER");
		this.cenario.cadastraAposta("daniel", 80, "VAI ACONTECER");
	}
	
	@Test
	public void testCriaCenarioSimples() {
		this.cenario = new Cenario("vai ganhar", 1);
	}
	
	@Test(expected=NullPointerException.class)
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

	@Test
	public void testCadastraApostaSimples() {
		this.cenario.cadastraAposta("daniel", 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeNull() {
		this.cenario.cadastraAposta(null, 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeVazio() {
		this.cenario.cadastraAposta("  ", 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorZero() {
		this.cenario.cadastraAposta("daniel", 0, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorMenorQueZero() {
		this.cenario.cadastraAposta("daniel", -4, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoNull() {
		this.cenario.cadastraAposta("daniel", 10, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.cenario.cadastraAposta("daniel", 10, "    ");
	}
	
	@Test
	public void testCadastraApostaPrevisaoNaoVaiAcontecer() {
		this.cenario.cadastraAposta("daniel", 10, "N VAI ACONTECER");
	}
	
	@Test
	public void testCadastraApostaPrevisaoVaiAcontecer() {
		this.cenario.cadastraAposta("daniel", 10, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoInvalida() {
		this.cenario.cadastraAposta("daniel", 10, "ALGUMA COISA");
	}
	
	@Test
	public void testValorApostas() {
		assertEquals("Valores não conferem", this.cenario.valorApostas(), 105);
	}
	
	@Test
	public void testTotalApostas() {
		assertEquals("Valores não conferem", this.cenario.totalApostas(), 3);
	}

	@Test
	public void testListaApostas() {
		String lista = "daniel - 10 - VAI ACONTECER\n"
				+ "daniel - 15 - N VAI ACONTECER\n"
				+ "daniel - 80 - VAI ACONTECER\n";
		assertEquals("Listas não conferem", this.cenario.listaApostas(), lista);
	}
	
	@Test
	public void testFecharApostaTrue() {
		this.cenario.fecharAposta(true);
	}
	
	@Test
	public void testFecharApostaFalse() {
		this.cenario.fecharAposta(false);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaMaisDeUmaVez() {
		this.cenario.fecharAposta(true);
		this.cenario.fecharAposta(true);
	}

	@Test
	public void testValorParaDistribuirSimples() {
		this.cenario.fecharAposta(true);
		assertEquals("Valor incorreto", this.cenario.valorParaDistribuir(0.1), 13);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaDistribuirApostaAberta() {
		this.cenario.valorParaDistribuir(0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaDistribuirPorcentagemMenorQue0() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaDistribuirPorcentagemMaiorQue1() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(2);
	}
	
	@Test
	public void testValorParaCaixaSimples() {
		this.cenario.fecharAposta(true);
		assertEquals("Valor incorreto", this.cenario.valorParaDistribuir(0.1), 13);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaCaixaApostaAberta() {
		this.cenario.valorParaDistribuir(0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaCaixaPorcentagemMenorQue0() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaCaixaPorcentagemMaiorQue1() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(2);
	}
	
	@Test
	public void testToString() {
		String str = "1 - vai ganhar - Nao finalizado";
		assertEquals("Strings diferentes", this.cenario.toString(), str);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
