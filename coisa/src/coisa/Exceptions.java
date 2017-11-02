package coisa;

/**
 * Funcoes que imprimem mensagem em caso de erro.
 * 
 * @author Daniel Coura
 */
public class Exceptions {
	
	/**
	 * Imprime mensagem de erro no caso do comando receber mais ou menos 
	 * argumentos do que o necessario. 
	 * 
	 * @param comando o comando com erro na quantidade de argumentos
	 * @param numeroArgumentos o numero de argumentos passados
	 * @param minimo o numero minimo de argumentos que o comando exige
	 * @param maximo o numero maximo de argumentos que o comando aceita
	 */
	public static void numeroArgumentos(String comando, int numeroArgumentos, int minimo, int maximo) {
		if (numeroArgumentos > maximo) { 
			System.out.printf("O comando %s suporta até %d argumentos", comando, maximo);
		} else if (numeroArgumentos < minimo) {
			System.out.printf("O comando %s recebe pelo menos %d argumentos\n", comando, minimo);
		}
	}
}
