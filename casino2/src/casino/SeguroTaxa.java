package casino;

public class SeguroTaxa extends Seguro {
	private double taxa;
	
	public SeguroTaxa(double newTaxa, int valor) {
		this.taxa= newTaxa;
		this.valor = (int) (valor * newTaxa);
	}
	
	public void setTaxa(double taxaSeguro) {
		this.valor = (int)(this.valor * taxaSeguro / this.taxa);
		this.taxa = taxaSeguro;
	}
	
	@Override
	public String toString() {
		return "ASSEGURADA (VALOR) - R$ " + (int) (this.taxa * 100) + "%";
	}
	
}
