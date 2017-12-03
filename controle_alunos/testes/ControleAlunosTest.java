import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import alunos.ControleAlunos;

public class ControleAlunosTest {

	private ControleAlunos ca;
	
	@Before
	public void criaControleAlunos() {
		this.ca = new ControleAlunos();
		ca.cadastraAluno("123", "asdf", "cc");
		ca.cadastraGrupo("gp");
	}
	
	/**
	 * Testa se o sistema cadastra aluno com parâmetros comuns.
	 */
	@Test
	public void testCadastraAlunoSimples() {
		ca.cadastraAluno("1234", "asdf", "cc");
	}

	/**
	 * Testa se o sistema cadastra aluno já existente.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoExistente() {
		ca.cadastraAluno("123", "asdf", "cc");
	}
	
	/**
	 * Testa se o sistema cadastra aluno com matricula null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaNull() {
		ca.cadastraAluno(null, "asdf", "cc");
	}
	
	/**
	 * Testa se o sistema cadastra aluno com matricula vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaVazia() {
		ca.cadastraAluno("   ", "asdf", "cc");
	}
	
	/**
	 * Testa se o sistema cadastra aluno com nome null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoNomeNull() {
		ca.cadastraAluno("1234", null, "cc");
	}
	
	/**
	 * Testa se o sistema cadastra aluno com nome vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoNomeVazio() {
		ca.cadastraAluno("1234", "    ", "cc");
	}
	
	/**
	 * Testa se o sistema cadastra aluno com curso null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoCursoNull() {
		ca.cadastraAluno("1234", "asdf", null);
	}
	
	/**
	 * Testa se o sistema cadastra aluno com curso vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraAlunoCursoVazio() {
		ca.cadastraAluno("1234", "asdf", "   ");
	}
	
	/**
	 * Testa se o sistema exibe o aluno corretamente.
	 */
	@Test
	public void testExibeAluno() {
		assertEquals("Exibição de aluno incorreta", ca.exibeAluno("123"), "123 - asdf - cc");
	}
	
	/**
	 * Testa se o sistema exibe o aluno com matrícula inexistente.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testExibeAlunoMatriculaInexistente() {
		ca.exibeAluno("1234");
	}
	
	/**
	 * Testa se o sistema exibe o aluno com matrícula null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testExibeAlunoMatriculaNull() {
		ca.exibeAluno(null);
	}
	
	/**
	 * Testa se o sistema exibe o aluno com matrícula vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testExibeAlunoMatriculaVazia() {
		ca.exibeAluno("    ");
	}
	
	/**
	 * Testa se o sistema cadastra grupo comum.
	 */
	@Test
	public void testCadastraGrupo() {
		ca.cadastraGrupo("grupo");
	}
	
	/**
	 * Testa se o sistema cadastra grupo já existente.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraGrupoExistente() {
		ca.cadastraGrupo("gp");
	}
	
	/**
	 * Testa se o sistema cadastra grupo já existente com caixa Alta.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraGrupoExistenteCaixaAlta() {
		ca.cadastraGrupo("gP");
	}
	
	/**
	 * Testa se o sistema cadastra grupo null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraGrupoNull() {
		ca.cadastraGrupo(null);
	}
	
	/**
	 * Testa se o sistema cadastra grupo vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraGrupoVazio() {
		ca.cadastraGrupo("   ");
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo.
	 */
	@Test
	public void testAlocaAlunoSimples() {
		ca.alocaAluno("123", "gp");
	}
	
	/**
	 * Testa se o sistema aloca aluno mais de uma vez.
	 */
	@Test
	public void testAlocaAlunoVariasVezes() {
		ca.alocaAluno("123", "gp");
		ca.alocaAluno("123", "gp");
	}
	
	/**
	 * Testa se o sistema aloca aluno inexistente em grupo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoInexistente() {
		ca.alocaAluno("1234", "gp");
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo inexistente.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoGrupoInexistente() {
		ca.alocaAluno("123", "grupo");
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo caixa alta.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoGrupoCaixaAlta() {
		ca.alocaAluno("1234", "gP");
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo com nome do aluno null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoNomeNull() {
		ca.alocaAluno(null, "gP");
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo com nome do aluno vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoNomeVazio() {
		ca.alocaAluno("   ", "gP");
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo com nome do grupo null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoGrupoNull() {
		ca.alocaAluno("123", null);
	}
	
	/**
	 * Testa se o sistema aloca aluno em grupo com nome do aluno vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlocaAlunoGrupoVazio() {
		ca.alocaAluno("123", "   ");
	}
	
	/**
	 * Testa se o sistema lista grupo com nome do grupo correto.
	 */
	@Test
	public void testListaGrupo() {
		ca.cadastraAluno("321", "asdf", "cc");
		ca.alocaAluno("123", "gp");
		ca.alocaAluno("321", "gp");
		assertEquals("Listagem incorreta", ca.listaGrupo("gp"), "* 123 - asdf - cc\n* 321 - asdf - cc\n");
	}
	
	/**
	 * Testa se o sistema cadastra respondedor comum.
	 */
	@Test
	public void testCadastraRespondedorSimples() {
		ca.cadastraRespondedor("123");
	}
	
	/**
	 * Testa se o sistema cadastra respondedor com matrícula inexistente.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraRespondedorMatriculaInexistente() {
		ca.cadastraRespondedor("321");
	}
	
	/**
	 * Testa se o sistema cadastra respondedor com matrícula null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraRespondedorMatriculaNull() {
		ca.cadastraRespondedor(null);
	}
	
	/**
	 * Testa se o sistema cadastra respondedor com matrícula vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraRespondedorMatriculaVazia() {
		ca.cadastraRespondedor("    ");
	}
	
	/**
	 * Testa se o sistema lista respondedores.
	 */
	@Test
	public void testListaRespondedores() {
		ca.cadastraAluno("321", "rubes", "cc");
		ca.cadastraRespondedor("123");
		ca.cadastraRespondedor("321");
		assertEquals("Listagem de respondedores incorreta", ca.listaRespondedores(), "1. 123 - asdf - cc\n2. 321 - rubes - cc\n");
	}
	
	
	
	
}
