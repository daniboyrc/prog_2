package coisa;

public class ContaCantina {
	private String nomeCantina;
	private int debito;
	private int qtdItens;
	private String[] detalhes = new String[5];
	private int qtdDetalhes;
	
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
	public String getNomeCantina() {
		return this.nomeCantina;
	}
	
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		  this.qtdItens += qtdItens;
		  this.debito += valorCentavos;
	}

	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhe) {
		  this.qtdItens += qtdItens;
		  this.debito += valorCentavos;
		  adicionaDetalhe(detalhe);
	}
	
	public void adicionaDetalhe(String detalhe) {
		if (this.qtdDetalhes == 5) {
			String[] arrayTmp = new String[5];
			for (int i = 0; i < 5; i++) {
				arrayTmp[i] = this.detalhes[i + 1];
			}
			arrayTmp[4] = detalhe;
			this.detalhes = arrayTmp;
		}
		this.qtdDetalhes += 1;
		this.detalhes[this.qtdDetalhes - 1] = detalhe;
	}
	
	public String listarDetalhes() {
		String var = "";
		for (int i = 0; i < 5; i++) {
			var += this.detalhes[i] + ", ";
		}
		return var;
	}
	
	public void pagaConta(int valorCentavos) {
		this.debito -= valorCentavos;
	}
	
	public String toString() {
		return this.nomeCantina + " " + this.qtdItens + " " + this.debito;
	}
}
