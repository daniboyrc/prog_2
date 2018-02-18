package casino;

import java.util.Comparator;

/**
 * Classe que compara cenários por meio da ordem alfabética
 * da descrição do Cenário
 * 
 * @author daniel
 */
public class ComparaNome implements Comparator<Cenario> {

	/**
	 * Compara cenário por meio da ordem alfabética de sua descrição
	 * 
	 * @param c1 o primeiro cenario
	 * @param c2 o segundo cenario
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}

}
