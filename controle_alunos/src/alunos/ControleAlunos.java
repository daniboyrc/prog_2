package alunos;
import java.util.ArrayList;
import java.util.HashMap;

/** 
 * Classe responsável por controlar e administrar os alunos
 * e grupos de estudo.
 * 
 * @author daniel coura
 */
public class ControleAlunos {
	
	private HashMap<String, Aluno> alunos;
	private HashMap<String, GrupoEstudo> grupos;
	private ArrayList<String> respondedores;

	/**
	 * Inicializa o sistema de controle.
	 */
	public ControleAlunos() {
		this.alunos = new HashMap<String, Aluno>();
		this.grupos = new HashMap<String, GrupoEstudo>();
		this.respondedores = new ArrayList<String>();
	}
	
	/**
	 * Cadastra aluno no sistema a partir da matrícula, do nome e do curso.
	 * Só pode haver uma matrícula cadastrada.
	 * 
	 * @param matricula a matricula do aluno
	 * @param nome o nome do aluno
	 * @param curso o nome do curso
	 */
	public void cadastraAluno(String matricula, String nome, String curso) {
		if (!alunos.containsKey(matricula)) {
			try {
				alunos.put(matricula, new Aluno(matricula, nome, curso));
			} catch (IllegalArgumentException iae) {
				throw iae;
			}
		} else {
			throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
		}
	}
	
	/**
	 * Retorna dados de um aluno. Pesquisa feita a partida da matrícula.
	 * 
	 * @param matricula a matricula do aluno
	 * @return a representação em String do aluno
	 */
	public String exibeAluno(String matricula) {
		if (matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido");
		} else if (alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		} else {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		}
	}
	
	/**
	 * Cadastra grupo de estudo no sistema a partir do nome.
	 * 
	 * @param grupo o nome do grupo de estudo
	 */
	public void cadastraGrupo(String grupo) {
		if (grupo == null || grupo.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido");
		} else if (!this.grupos.containsKey(grupo.toLowerCase())) {
			try {
				grupos.put(grupo.toLowerCase(), new GrupoEstudo(grupo));
			} catch (IllegalArgumentException iae) {
				throw iae;
			}
		} else {
			throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
		}
	}
	
	/**
	 * Aloca aluno em um grupo a partir da matrícula do aluno e do 
	 * nome do grupo de estudo.
	 * 
	 * @param matricula a matricula do aluno
	 * @param grupo o nome do grupo de estudo
	 */
	public void alocaAluno(String matricula, String grupo) {
		if (grupo == null || grupo.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido");
		} else if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Aluno não cadastrado!");
		} else if (!this.grupos.containsKey(grupo.toLowerCase())) {
			throw new IllegalArgumentException("Grupo não cadastrado!");
		}
		grupos.get(grupo.toLowerCase()).adicionaAluno(alunos.get(matricula));
	}
	
	/**
	 * Retorna a lista de alunos de um determinado grupo determinado grupo.
	 * 
	 * @param grupo o nome do grupo de estudo
	 * @return a lista de alunos do grupo informado
	 */
	public String listaGrupo(String grupo) {
		if (grupo == null || grupo.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido");
		} else if (!this.grupos.containsKey(grupo.toLowerCase())) {
			throw new IllegalArgumentException("Grupo não existe");
		}
		return this.grupos.get(grupo.toLowerCase()).listaGrupo();
	}
	
	/**
	 * Cadastra um aluno que respondeu uma pergunta. Pode cadastrar o mesmo
	 * aluno mais de uma vez.
	 * 
	 * @param matricula a matricula do aluno
	 */
	public void cadastraRespondedor(String matricula) {
		if (matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException("Valor inválido");
		} else if (alunos.containsKey(matricula)) {
			respondedores.add(matricula);
		} else {
			throw new IllegalArgumentException("Aluno não cadastrado.");
		}
	}
	
	/**
	 * Retorna a lista enumerada de alunos que responderam as perguntas.
	 * A lista é sequencial.
	 * 
	 * @return a lista de alunos que responderam as perguntas
	 */
	public String listaRespondedores() {
		String lista = "";
		int cont = 1;
		for (String matricula : respondedores) {
			lista += cont + ". " + alunos.get(matricula).toString() + System.lineSeparator();
			cont += 1;
		}
		
		return lista;
	}
	
}
