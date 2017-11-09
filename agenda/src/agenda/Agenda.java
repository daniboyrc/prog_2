package agenda;

/** 
 * Classe responsavel por armazenar e manipular objetos da classe contato.
 * Pode armazenar ate 100 contatos
 * 
 * @author danielrc
 *
 */

public class Agenda {
	private Contato[] contatos = new Contato[101];
	
	/**
	 * Adiciona contato a agenda.
	 *  
	 * @param posicao a posicao na do contato na agenda
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @param telefone o telefone do contato
	 * @return um booleano que sera true caso a operacao tenha sido bem sucedida
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		try {
		contatos[posicao] = new Contato(nome, sobrenome, telefone);
		return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
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
		return contatos[posicao].toString();
	}
	
	/**
	 * Lista todos os contatos da agenda.
	 * 
	 * @return a lista de contatos da agenda.
	 */
	public String listaContatos() {
		String lista = "";
		for (int i = 1; i <= 100; i++) {
			if (contatos[i] != null){
				lista += contatos[i] + "\n";
			}
		}
		return lista;
	}
}
