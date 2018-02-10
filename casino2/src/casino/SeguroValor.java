package casino;

public class SeguroValor extends Seguro{
	private int valor;
	
	public SeguroValor(int valor) {
		this.valor = valor;
	}
	
	public void setValor(int newValor) {
		this.valor = newValor;
	}
	
	@Override
	public String toString() {
		return "ASSEGURADA (VALOR) - R$ " + this.valor + ",00";
	}
}
