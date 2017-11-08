package agenda;
import java.util.Scanner;

/**
 * Classe que fornece a interface com o usuario.
 * 
 * @author danielrc
 *
 */
public class Main {
	
	/**
	 * Método principal que interpreta as entradas do usuario.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		while(true) {
			System.out.println("(C)adastrar contato");
			System.out.println("(L)ista contatos");
			System.out.println("(E)xibir contato");
			System.out.println("(S)air");
			System.out.print("\nOpção> ");
			String opc = sc.nextLine();
			
			if(opc.equals("S")) {
				break;
			} else if (opc.equals("C")) {
				System.out.print("Posição: ");
				int posicao = sc.nextInt();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Sobrenome: ");
				String sobrenome = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();
				
				agenda.cadastraContato(posicao, nome, sobrenome, telefone);
				
			} else if (opc.equals("E")) {
				System.out.print("Contato> ");
				int posicao = sc.nextInt();
				
				System.out.println(agenda.pesquisaContato(posicao));
			} else if (opc.equals("L")) {
				System.out.println(agenda.listaContatos());
			}
		}
		sc.close();
	}
}
