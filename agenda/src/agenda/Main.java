package agenda;
import java.util.Scanner;

/**
 * Classe que fornece a interface de interacao com o usuario.
 * 
 * @author danielrc
 *
 */
public class Main {
	
	/**
	 * Metodo principal que interpreta as entradas do usuario.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		while(true) {
			listaOpcoes();
			String opc = sc.nextLine();
			
			if(opc.equals("S")) {
				break;
			} else if (opc.equals("C")) {
				adicionaContato(sc, agenda);
				
			} else if (opc.equals("E")) {
				exibeContato(sc, agenda);
			} else if (opc.equals("L")) {
				System.out.println(agenda.toString());
			}
		}
		sc.close();
	}
	
	/**
	 * Lista o menu de operacoes que o usuario pode realizar.
	 */
	private static void listaOpcoes() {
		System.out.println("(C)adastrar contato");
		System.out.println("(L)ista contatos");
		System.out.println("(E)xibir contato");
		System.out.println("(S)air");
		System.out.print("\nOpção> ");
	}
	
	/**
	 * Exibe o formulario para cadastrar um novo contato.
	 * 
	 * @param sc o objeto para ler as entradas
	 * @param agenda a agenda a ser manipulada
	 */
	private static void adicionaContato(Scanner sc, Agenda agenda) {
		System.out.print("Posição: ");
		int posicao = sc.nextInt();
		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Sobenome: ");
		String sobrenome = sc.nextLine();
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		
		try { 
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.println("CONTATO CADASTRADO!\n");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println(aiobe.getMessage());
		}
	}
	
	/**
	 * Mostra os dados do contato que o usuario informou atraves
	 * da posicao.
	 * 
	 * @param sc o objeto para ler as entradas
	 * @param agenda a agenda a ser manipulada
	 */
	private static void exibeContato(Scanner sc, Agenda agenda) {
		System.out.print("Contato> ");
		int posicao = sc.nextInt();
		
		try {
			System.out.println(agenda.pesquisaContato(posicao));
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println(aiobe.getMessage());
		}
	}
}
