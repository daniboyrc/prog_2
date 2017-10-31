package coisa;

public class Exceptions {
	public static void numeroArgumentos(String comando, int numeroArgumentos, int minimo, int maximo) {
		if (numeroArgumentos > maximo) { 
			System.out.printf("O comando %s suporta até %d argumentos", comando, maximo);
		} else if (numeroArgumentos < minimo) {
			System.out.printf("O comando %s recebe pelo menos %d argumentos\n", comando, minimo);
		}
	}
	
	public static void nomeRepetido(String palavra, String contexto) {
		System.out.printf("Já existe %s em %s", palavra, contexto);
	}
}
