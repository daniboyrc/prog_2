package coisa;

public class ContaLaboratorio {
	private String nomeLaboratorio;
	private int espacoOcupado;
	private int cota;

	public String getNomeLaboratorio() {
		return this.nomeLaboratorio;
	}
	
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}
	
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	public boolean atingiuCota() {
		return (this.espacoOcupado >= this.cota);
	}
	
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}
