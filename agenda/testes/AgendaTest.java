/**
 * Classe que testa os métodos da classe Agenda
 * 
 * @author Daniel Coura
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import agenda.Agenda;


public class AgendaTest {
	private Agenda agendaBasica;

	/**
	 * Cria uma agenda sem nenhum elemento.
	 */
	@Before
	public void CriaAgenada() {
		this.agendaBasica = new Agenda();
	}
	
	/**
	 * Testa se o contato e cadastrado em uma posicao vazia.
	 */
	@Test
	public void testeAddContatoPosicaoVazia() {
		this.agendaBasica.cadastraContato(1, "Daniel", "Rodrigues", "(83)99169-3620");
	}
	
	/**
	 * Testa se o contato e cadastrado em uma posicao que ja contem um elemento.
	 */
	@Test
	public void testeAddContatoPosicaoOcupada() {
		this.agendaBasica.cadastraContato(1, "Daniel", "Rodrigues", "(83)99169-3620");
		this.agendaBasica.cadastraContato(1, "Rodrigues", "Coura", "(83)99169-1234");
		assertEquals("Erro de sobrescrita", agendaBasica.pesquisaContato(1), "Rodrigues Coura - (83)99169-1234");
	}
	
	/**
	 * Testa se o metodo adiciona contato na posicao limite 1.
	 */
	@Test
	public void testeAddContatoPosicaoLimiteUm() {
		this.agendaBasica.cadastraContato(1, "Daniel", "Rodrigues", "(83)99169-3620");
	}
	
	/**
	 * Testa se o metodo adiciona contato na posicao limite 100. 
	 */
	@Test
	public void testeAddContatoPosicaoLimiteCem() {
		this.agendaBasica.cadastraContato(100, "Daniel", "Rodrigues", "(83)99169-3620");
	}
	
	/**
	 * Testa se o metodo adiciona contato em posicao menor que 1.
	 */
	@Test
	public void testeAddContatoPosicaoMenorQueUm() {
		try {
			this.agendaBasica.cadastraContato(0, "Daniel", "Rodrigues", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se o metodo adiciona contato em posicao maior que 100.
	 */
	@Test
	public void testeAddContatoPosicaoMaiorQueCem() {
		try {
			this.agendaBasica.cadastraContato(101, "Daniel", "Rodrigues", "(83)99169-3620");
			fail("Era esperada uma excessão");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se o metodo pesquisa contato em posicao que nao contem contato.
	 */
	@Test
	public void pesquisaContatoPosicaoVazia() {
		try {
			agendaBasica.pesquisaContato(10);
			fail("Era esperada uma excessão");
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Testa se o metodo adiciona contato na posicao limite 1.
	 */
	@Test
	public void pesquisaContatoPosicaoLimiteUm() {
		agendaBasica.cadastraContato(1, "Daniel", "Rodrigues", "1234-4321");
		agendaBasica.pesquisaContato(1);
	}

	/**
	 * Testa se o metodo adiciona contato na posicao limite 100.
	 */
	@Test
	public void pesquisaContatoPosicaoLimiteCem() {
		agendaBasica.cadastraContato(100, "Daniel", "Rodrigues", "1234-4321");
		agendaBasica.pesquisaContato(100);
	}
	
	/**
	 * Testa se o metodo adiciona em posicao menor que 1.
	 */
	@Test
	public void pesquisaContatoMenorQueUm() {
		try {
			agendaBasica.cadastraContato(0, "Daniel", "Rodrigues", "1234-4321");
			agendaBasica.pesquisaContato(0);
			fail("Era esperada uma falha");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Testa se o metodo adiciona em posicao maior que 100.
	 */
	@Test
	public void pesquisaContatoMaiorQueCem() {
		try {
			agendaBasica.cadastraContato(101, "Daniel", "Rodrigues", "1234-4321");
			agendaBasica.pesquisaContato(101);
			fail("Era esperada uma falha");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Testa se o metodo retorna a String esperada.
	 */
	@Test
	public void testeToString() {
		this.agendaBasica.cadastraContato(1, "nome", "sobre", "1234");
		this.agendaBasica.cadastraContato(14, "sobre", "nome", "4321");
		assertEquals("Strings diferentes", this.agendaBasica.toString(), "1 - nome sobre - 1234\n14 - sobre nome - 4321\n");
	}
	
}
