package agenda;

/** 
 * Classe responsavel por armazenar e manipular objetos da classe contato.
 * Pode armazenar ate 100 contatos
 * 
 * @author danielrc
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
	 * @return um booleano que sera true caso a operacao tenha sido bem sucedida
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição fora dos limites da Agenda");
		}
		try {
			contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
		} catch(IllegalArgumentException iae) {
			throw iae;
		}
	}
	
	/**
	 * Retorna informacoes do contato na posicao informada.
	 * 
	 * @param posicao a posicao do contato na agenda
	 * @return as informacoes do contato
	 */
	public String pesquisaContato(int posicao) {
		if (contatos[posicao - 1] == null) {
			throw new IllegalArgumentException("Não há elementos na posição informada");
		} else if (posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("Posição fora dos limites da Agenda");
		}
		return contatos[posicao - 1].toString();
	}
	
	/**
	 * Retorna a representacao em String da agenda na
	 * forma de lista de contatos. Cada linha da lista 
	 * segue o formato: POSICAO - NOME SOBRENOME - TELEFONE
	 * 
	 * @return A representacao em String da agenda
	 */
	public String toString() {
		String lista = "";
		for (int i = 0; i <= 99; i++) {
			if (contatos[i] != null){
				lista += (i+1) + " - " + contatos[i].toString() + "\n";
			}
		}
		return lista;
	}
}
