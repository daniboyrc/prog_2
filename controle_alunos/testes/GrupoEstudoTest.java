import static org.junit.Assert.*;
import org.junit.Test;
import alunos.Aluno;
import alunos.GrupoEstudo;

public class GrupoEstudoTest {

	private GrupoEstudo ge;
	
	/*
	 * Testa se cria grupo de estudo comum.
	 */
	@Test
	public void criaGrupoEstudoSimples() {
		this.ge = new GrupoEstudo("asdf"); 
	}
	
	/*
	 * Testa se cria grupo de estudo com nome null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaGrupoEstudoNomeNull() {
		this.ge = new GrupoEstudo(null); 
	}
	
	/*
	 * Testa se cria grupo de estudo com nome vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaGrupoEstudoNomeVazio() {
		this.ge = new GrupoEstudo("   "); 
	}
	
	/*
	 * Testa se adiciona aluno comum ao grupo.
	 */
	@Test
	public void testAdicionaAlunoSimples() {
		Aluno aln = new Aluno("1234", "qwer", "cc");
		this.ge = new GrupoEstudo("asdf");
		this.ge.adicionaAluno(aln);
		assertEquals("Não cadastrado", this.ge.listaGrupo(), "* 1234 - qwer - cc\n");
	}
	
	/*
	 * Testa a listagem de alunos.
	 */
	@Test
	public void testListaAlunos() {
		Aluno aln1 = new Aluno("1234", "qwer", "cc");
		Aluno aln2 = new Aluno("4321", "rewq", "cc");
		this.ge = new GrupoEstudo("asdf");
		this.ge.adicionaAluno(aln1);
		this.ge.adicionaAluno(aln2);
		assertEquals("Erro de listagem", this.ge.listaGrupo(), "* 4321 - rewq - cc\n* 1234 - qwer - cc\n");
	}
	
	/*
	 * Testa o equals com nomes de grupos diferentes.
	 */
	@Test
	public void testEqualsNomesDiferentes() {
		Aluno aln = new Aluno("1234", "qwer", "cc");
		this.ge = new GrupoEstudo("asdf");
		this.ge.adicionaAluno(aln);
		GrupoEstudo ge2 = new GrupoEstudo("qwer");
		assertFalse(this.ge.equals(ge2));
	}
	
	/*
	 * Testa o equals com nomes de grupos iguais.
	 */
	@Test
	public void testEqualsNomesIguais() {
		Aluno aln = new Aluno("1234", "qwer", "cc");
		this.ge = new GrupoEstudo("asdf");
		this.ge.adicionaAluno(aln);
		GrupoEstudo ge2 = new GrupoEstudo("asdf");
		assertTrue(this.ge.equals(ge2));
	}
	
	
}
