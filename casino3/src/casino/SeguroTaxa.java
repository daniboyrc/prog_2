package casino;

public class SeguroTaxa implements Seguro {
	private double taxa;
	private int valor;
	
	/**
	 * Constrói seguro assegurado por taxa através da taxa
	 * e do valor apostado.
	 * 
	 * @param newTaxa o valor da taxa
	 * @param valor o valor apostado
	 */
	public SeguroTaxa(double newTaxa, int valor) {
		if (newTaxa <= 0) {
			throw new IllegalArgumentException("Erro em SeguroTaxa: taxa não pode ser negativa ou nula");
		}
		this.taxa = newTaxa;
		this.valor = (int) (valor * newTaxa);
	}
	
	/**
	 * Retorna o valor do seguro.
	 * 
	 * @return o valor do seguro
	 */
	@Override
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna a representação em String do seguro por taxa.
	 * exemplo: ASSEGURADA (TAXA) - 10% 
	 *
	 * @return a representação em string do seguro
	 */
	@Override
	public String toString() {
		return "ASSEGURADA (TAXA) - " + (int) (this.taxa * 100) + "%";
	}	
	
	
}
