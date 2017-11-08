package agenda;

/** 
 * Classe responsavel por armazenar e manipular objetos da classe contato.
 * Pode armazenar ate 100 contatos
 * 
 * @author danielrc
 *
 */

public class Agenda {
	private Contato[] contatos = new Contato[100];
	
	/**
	 * Adiciona contato a agenda.
	 *  
	 * @param posicao a posicao na do contato na agenda
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @param telefone o telefone do contato
	 * @return o status da operacao em forma de String
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		try {
		contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
		return "CADASTRO REALIZADO!";
		
		} catch(ArrayIndexOutOfBoundsException e) {
			return "POSIÇÃO INVÁLIDA";
		}
	}
	
	/**
	 * Retorna informacoes do contato na posicao informada.
	 * 
	 * @param posicao a posicao do contato na agenda
	 * @return as informacoes do contato
	 */
	public String pesquisaContato(int posicao) {
		// Fazer try catch
		return contatos[posicao - 1].toString();
	}
	
	/**
	 * Lista todos os contatos da agenda.
	 * 
	 * @return a lista de contatos da agenda.
	 */
	public String listaContatos() {
		String lista = "";
		for (int i = 1; i <= 101; i++) {
			if (contatos[i] != null){
				lista += contatos[i - 1] + "\n";
			}
		}
		return lista;
	}
}
