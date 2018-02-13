package seguro;

public abstract class Seguro {
	protected int valor;
	
	/**
	 * Retorna o valor do seguro.
	 * 
	 * @return o valor do seguro
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Representação em String do seguro.
	 */
	public abstract String toString();
}
