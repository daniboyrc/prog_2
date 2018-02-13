package seguro;

public class SeguroValor extends Seguro{
	
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
