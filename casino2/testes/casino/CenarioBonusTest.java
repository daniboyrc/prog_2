package casino;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import casino.Cenario;

public class CenarioBonusTest {

	public Cenario cenario;
	
	@Before
	public void cenarioTeste() {
		this.cenario = new CenarioBonus("vai ganhar", 1, 1000);
		this.cenario.cadastraAposta("daniel", 10, "VAI ACONTECER");
		this.cenario.cadastraAposta("daniel", 15, "N VAI ACONTECER");
		this.cenario.cadastraAposta("daniel", 80, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cria cenário simples.
	 */
	@Test
	public void testCriaCenarioSimples() {
		this.cenario = new CenarioBonus("vai ganhar", 1, 1000);
	}
	
	/**
	 * Testa se cria cenário com descrição nula.
	 */
	@Test(expected=NullPointerException.class)
	public void testCriaCenarioNomeNulo() {
		this.cenario = new CenarioBonus(null, 1, 1000);
	}
	
	/**
	 * Testa se cria cenário com descrição vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioNomeVazio() {
		this.cenario = new CenarioBonus("  ", 1, 1000);
	}
	
	/**
	 * Testa se cria cenário com id igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioIdZero() {
		this.cenario = new CenarioBonus("vai ganhar", 0, 1000);
	}
	
	/**
	 * Testa se cria cenário com id negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioIdMenorQueZero() {
		this.cenario = new CenarioBonus("vai ganhar", -4, 1000);
	}

	/**
	 * Testa se cria cenário com bonus igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioBonusIgualZero() {
		this.cenario = new CenarioBonus("vai ganhar", 1, 0);
	}
	
	/**
	 * Testa se cria cenário com bonus negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaCenarioBonusMenorQueZero() {
		this.cenario = new CenarioBonus("vai ganhar", 1, -4);
	}

	/**
	 * Testa se cadastra aposta com valores corretos.
	 */
	@Test
	public void testCadastraApostaSimples() {
		this.cenario.cadastraAposta("daniel", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com nome nulo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeNull() {
		this.cenario.cadastraAposta(null, 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com nome vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaNomeVazio() {
		this.cenario.cadastraAposta("  ", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com valor igual a zero.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorZero() {
		this.cenario.cadastraAposta("daniel", 0, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com valor negativo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaValorMenorQueZero() {
		this.cenario.cadastraAposta("daniel", -4, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com previsão nula.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoNull() {
		this.cenario.cadastraAposta("daniel", 10, null);
	}
	
	/**
	 * Testa se cadastra aposta com previsão vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.cenario.cadastraAposta("daniel", 10, "    ");
	}
	
	/**
	 * Testa se cadastra aposta com previsão correta "N VAI ACONTECER".
	 */
	@Test
	public void testCadastraApostaPrevisaoNaoVaiAcontecer() {
		this.cenario.cadastraAposta("daniel", 10, "N VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com previsão correta "VAI ACONTECER".
	 */
	@Test
	public void testCadastraApostaPrevisaoVaiAcontecer() {
		this.cenario.cadastraAposta("daniel", 10, "VAI ACONTECER");
	}
	
	/**
	 * Testa se cadastra aposta com previsão incorreta.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoInvalida() {
		this.cenario.cadastraAposta("daniel", 10, "ALGUMA COISA");
	}
	
	/**
	 * Verifica se a soma total dos valores das apostas está correta.
	 */
	@Test
	public void testValorApostas() {
		assertEquals("Valores não conferem", this.cenario.valorApostas(), 105);
	}
	
	/**
	 * Verifica se a quatidade das apostas está correta.
	 */
	@Test
	public void testTotalApostas() {
		assertEquals("Valores não conferem", this.cenario.totalApostas(), 3);
	}

	/**
	 * Verifica se a listagem das apostas está correta.
	 */
	@Test
	public void testListaApostas() {
		String lista = "daniel - 10 - VAI ACONTECER\n"
				+ "daniel - 15 - N VAI ACONTECER\n"
				+ "daniel - 80 - VAI ACONTECER\n";
		assertEquals("Listas não conferem", this.cenario.listaApostas(), lista);
	}
	
	/**
	 * Testa se fecha aposta com veredito true.
	 */
	@Test
	public void testFecharApostaTrue() {
		this.cenario.fecharAposta(true);
	}
	
	/**
	 * Testa se fecha aposta com veredito false.
	 */
	@Test
	public void testFecharApostaFalse() {
		this.cenario.fecharAposta(false);
	}
	
	/**
	 * Testa se fecha aposta mais de uma vez.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFecharApostaMaisDeUmaVez() {
		this.cenario.fecharAposta(true);
		this.cenario.fecharAposta(true);
	}

	/**
	 * Verifica o valor para distribuir entre os vencedores.
	 */
	@Test
	public void testValorParaDistribuirSimples() {
		this.cenario.fecharAposta(true);
		assertEquals("Valor incorreto", this.cenario.valorParaDistribuir(0.1), 1014);
	}
	
	/**
	 * Verifica o valor para distribuir entre os vencedores com aposta aberta.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaDistribuirApostaAberta() {
		this.cenario.valorParaDistribuir(0.1);
	}
	
	/**
	 * Verifica o valor para distribuir passando porcentagem negativa.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaDistribuirPorcentagemMenorQue0() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(-1);
	}
	
	/**
	 * Verifica o valor para distribuir passando porcentagem maior que 1.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaDistribuirPorcentagemMaiorQue1() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(2);
	}

	/**
	 * Verifica o valor para caixa.
	 */
	@Test
	public void testValorParaCaixaSimples() {
		this.cenario.fecharAposta(true);
		assertEquals("Valor incorreto", this.cenario.valorParaCaixa(0.1), 1);
	}
	
	/**
	 * Verifica o valor para distribuir com aposta aberta.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaCaixaApostaAberta() {
		this.cenario.valorParaDistribuir(0.1);
	}
	
	/**
	 * Verifica o valor para caixa passando porcentagem negativa.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaCaixaPorcentagemMenorQue0() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(-1);
	}
	
	/**
	 * Verifica o valor para distribuir passando porcentagem maior que 1.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testValorParaCaixaPorcentagemMaiorQue1() {
		this.cenario.fecharAposta(true);
		this.cenario.valorParaDistribuir(2);
	}
	
	/**
	 * Verifica a representação em String do cenário.
	 */
	@Test
	public void testToString() {
		String str = "1 - vai ganhar - Nao finalizado - R$ 10,00";
		assertEquals("Strings diferentes", this.cenario.toString(), str);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
