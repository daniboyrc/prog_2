package casino;

public class SeguroValor implements Seguro{
	private int valor;
	
	/**
	 * Constrói um seguro do tipo valor através do valor assegurado.
	 * 
	 * @param valor o valor a ser assegurado
	 */
	public SeguroValor(int valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro em SeguroValor: valor não pode ser negativo ou nulo");
		}
		this.valor = valor;
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
	 * Retorna a representação em String do seguro.
	 * exemplo: ASSEGURADA (VALOR) - R$ 10,00
	 * 
	 * @return a representação em String do seguro do tipo taxa
	 */
	@Override
	public String toString() {
		return "ASSEGURADA (VALOR) - R$ " + this.valor + ",00";
	}
}
