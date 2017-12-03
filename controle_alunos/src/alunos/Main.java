package alunos;
import java.util.Scanner;

/**
 * Classe que fornece a interface de interação com o usuário.
 * 
 * @author daniel coura
 *
 */
public class Main {
	
	/**
	 * Metodo principal que matém o loop do sistema.
	 * 
	 * @param args
	 */
	public static void main(String[] Args) {
		ControleAlunos ca = new ControleAlunos();
		String opcao = "";
		while (!opcao.equals("O")) {
			Scanner sc = new Scanner(System.in);
			opcao = getOpcao(sc);
			trataOpcao(opcao, sc, ca);
		}
	}
	
	/**
	 * Imprime o menu e retorna a entrada do usuário.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @return a opção informada pelo usuário
	 */
	private static String getOpcao(Scanner sc) {
		System.out.print("\n(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Resposta de Aluno\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!" + 
				"\nOpção> ");
		return sc.nextLine();
	}
	
	/**
	 * Interpreta a opção informada pelo usuário e chama o devido
	 * método para tratar a solitação.
	 * 
	 * @param opcao a opção informada pelo usuário
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void trataOpcao(String opcao, Scanner sc, ControleAlunos ca) {
		if (opcao.equals("C")) {
			cadastraAluno(sc, ca);
		} else if (opcao.equals("E")) {
			exibeAluno(sc, ca);
		} else if (opcao.equals("N")) {
			cadastraGrupo(sc, ca);
		} else if (opcao.equals("A")) {
			System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
			String opc = sc.nextLine();
			if (opc.equals("A")) {
				alocarAluno(sc, ca);
			} else if (opc.equals("I")) {
				listaGrupo(sc, ca);
			}
		} else if (opcao.equals("R")) {
			cadastraRespondedor(sc, ca);
		} else if (opcao.equals("I")) {
			listaRespondedores(ca);
		} else {
			throw new IllegalArgumentException("Argumento inválido!");
		}
	}
	
	/**
	 * Recebe as entradas do usuário e cadastra aluno.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void cadastraAluno(Scanner sc, ControleAlunos ca) {
		System.out.print("Matrícula: ");	
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		try {
			ca.cadastraAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Recebe as entradas do usuário e exibe os dados do aluno
	 * informado.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void exibeAluno(Scanner sc, ControleAlunos ca) {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		try {
			System.out.println(ca.exibeAluno(matricula));
		} catch (IllegalArgumentException iae) {
			System.out.print(iae.getMessage());
		}
	}
	
	/**
	 * Recebe as entradas do usuário e cadastra grupo.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void cadastraGrupo(Scanner sc, ControleAlunos ca) {
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		try {
			ca.cadastraGrupo(grupo);
			System.out.println("CADASTRO REALIZADO!");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Recebe as entradas do usuário e aloca aluno em grupo de estudo.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void alocarAluno(Scanner sc, ControleAlunos ca) {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		try {
			ca.alocaAluno(matricula, grupo);
			System.out.println("ALUNO ALOCADO!");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Recebe as entradas do usuário e lista os alunos do grupo
	 * de estudo informado pelo usuário.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void listaGrupo(Scanner sc, ControleAlunos ca) {
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		try {
			System.out.println(ca.listaGrupo(grupo));
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Recebe as entradas do usuário e cadastra aluno que respondeu
	 * uma pergunta.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void cadastraRespondedor(Scanner sc, ControleAlunos ca) {
		System.out.print("Matrícula: ");
		String matricula = sc.nextLine();
		try {
			ca.cadastraRespondedor(matricula);
			System.out.println("ALUNO REGISTRADO!");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Lista sequecialmente os alunos que responderam um pergunta.
	 * 
	 * @param sc o objeto do tipo Scanner para leitura do teclado
	 * @param ca a instância da class ControleAlunos
	 */
	private static void listaRespondedores(ControleAlunos ca) {
		System.out.println(ca.listaRespondedores());	
	}
}
