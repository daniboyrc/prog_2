package casino;

import easyaccept.EasyAccept;

public class Facade {
	private ControleSistema controle = new ControleSistema();
	
	public static void main(String args[]) {
		args = new String[] {"casino.Facade",
				"acceptance_test/us1_test.txt",
				"acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt",
				"acceptance_test/us4_test.txt"};
		EasyAccept.main(args);
	}
	
	public void inicializa(int caixa, double porcentagem) {
		this.controle.inicializaSistema(caixa, porcentagem);
	}
	
	public int getCaixa() {
		return this.controle.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return controle.cadastraCenario(descricao);
	}
	
	public String exibirCenario(int cenario) {
		return controle.getCenario(cenario);
	}
	
	public String exibirCenarios() {
		return controle.listaCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String  previsao) {
		this.controle.cadastraAposta(cenario, apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		return this.controle.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return this.controle.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.controle.listaApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controle.fecharAposta(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return this.controle.getTotalCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario)
	{
		return this.controle.getTotalRateioCenario(cenario);
	}

}