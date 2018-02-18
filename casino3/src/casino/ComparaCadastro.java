package casino;

import java.util.Comparator;

/**
 * Classe que compara cenários por meio do id do Cenario
 * 
 * @author daniel
 */
public class ComparaCadastro implements Comparator<Cenario> {

	/**
	 * Compara cenário através do id
	 * 
	 * @param c1 o primeiro cenario
	 * @param c2 o segundo cenario
	 */
	public int compare(Cenario c1, Cenario c2) {
		return c1.getId() - c2.getId();
	}
	
}
