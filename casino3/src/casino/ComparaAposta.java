package casino;

import java.util.Comparator;

/**
 * Classe que compara cenários por meio do número
 * de apostas.
 * 
 * @author daniel
 */
public class ComparaAposta implements Comparator<Cenario> {

	/**
	 * Compara cenários de acordo com o número de apostas
	 * 
	 * @param c1 o primeiro cenario
	 * @param c2 o segundo cenario
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c2.totalApostas() - c1.totalApostas();
	}

}
