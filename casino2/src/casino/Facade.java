package casino;

import easyaccept.EasyAccept;

public class Facade {
	private ControleSistema controle = new ControleSistema();
	
	public static void main(String args[]) {
		args = new String[] {"casino.Facade",
				"acceptance_test/us1_test.txt",
				"acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt",
				"acceptance_test/us4_test.txt",
				"acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt"};
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
	
	public int cadastrarCenario(String descricao, int bonus) {
		return controle.cadastraCenario(descricao, bonus);
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
	
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		return this.controle.cadastraApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
	}
	
	public void cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxaSeguro, int custo) {
		this.controle.cadastraApostaSeguraTaxa(cenario, apostador, valor, previsao, taxaSeguro, custo);
	}

	public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		this.controle.alteraSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		this.controle.alteraSeguroTaxa(cenario, apostaAssegurada, taxa);
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