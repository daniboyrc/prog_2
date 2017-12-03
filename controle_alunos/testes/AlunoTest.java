import static org.junit.Assert.*;
import org.junit.Test;

import alunos.Aluno;

public class AlunoTest {
	private Aluno aluno;
	
	/*
	 * Testa se cria aluno comum.
	 */
	@Test
	public void criaAlunoSimples() {
		this.aluno = new Aluno("1234", "daniel", "cc"); 
	}
	
	/*
	 * Testa se cria aluno com matrícula null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoMatriculaNull() {
		this.aluno = new Aluno(null, "daniel", "cc"); 
	}
	
	/*
	 * Testa se cria aluno com matrícula vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoMatriculaVazia() {
		this.aluno = new Aluno("   ", "daniel", "cc"); 
	}
	
	/*
	 * Testa se cria aluno com nome null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeNull() {
		this.aluno = new Aluno("1234", null, "cc"); 
	}
	
	/*
	 * Testa se cria aluno com node vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeVazio() {
		this.aluno = new Aluno("1234", "    ", "cc"); 
	}
	
	/*
	 * Testa se cria aluno com curso null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoCursoNull() {
		this.aluno = new Aluno("1234", "daniel", null); 
	}
	
	/*
	 * Testa se cria aluno com curso vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoCursoVazio() {
		this.aluno = new Aluno("1234", "daniel", "    "); 
	}

	/*
	 * Testa equals com alunos de matrículas difentes.
	 */
	@Test
	public void testEqualsMatriculasDiferentes() {
		this.aluno = new Aluno("1234", "daniel", "cc");
		Aluno aluno2 = new Aluno("2134", "asdf", "as");
		assertFalse(this.aluno.equals(aluno2));
	}
	
	/*
	 * Testa equals com alunos de matrículas iguais.
	 */
	@Test
	public void testEqualsMatriculasIguais() {
		this.aluno = new Aluno("1234", "daniel", "cc");
		Aluno aluno2 = new Aluno("1234", "asdf", "as");
		assertTrue(this.aluno.equals(aluno2));
	}
}
