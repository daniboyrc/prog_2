package casino;

/**
 * Classe que representa um casino no sistema
 * 
 * @author daniel coura
 */
public class Casino {
	private int caixa;
	private double porcentagem;
	
	/**
	 * Constrói casino a partir do valor de caixa inicial e 
	 * da porcentagem a ser descontada das apostas perdedoras 
	 * em cada cenário que será direcionada ao caixa do casino.
	 * 
	 * @param caixa o valor de caixa inicial do casino
	 * @param porcentagem a porcentagem a ser descontada
	 */
	public Casino(int caixa, double porcentagem) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		} else if (porcentagem <= 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		} else if (porcentagem > 1) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser superior a 1");
		}
		this.caixa = caixa;
		this.porcentagem = porcentagem;
	}
	
	/**
	 * Retorna o valor de caixa atual do casino.
	 * 
	 * @return o valor de caixa do casino
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Subtrai o valor de caixa.
	 * 
	 * @param valor o valor a ser subtraído
	 * @return o valor de caixa do casino
	 */
	public void retiraCaixa(int valor) {
		if (valor > caixa) {
			throw new IllegalArgumentException("O valor não pode ser maior que o caixa");
		}
		
		this.caixa -= valor;
	}
	
	/**
	 * Retorna a porcentagem a ser cobrada de cada cenário.
	 * 
	 * @return a porcentagem a ser cobrada de cada cenário
	 */
	public double getPorcentagem() {
		return this.porcentagem;
	}
	
	/**
	 * Soma o caixa atual com o valor informado.
	 * 
	 * @param valor a ser incrementado no caixa
	 */
	public void somaCaixa(int valor) {
		this.caixa += valor;
	}
	
	/**
	 * Retorna a representação em String do casino. A representação
	 * segue o formato: CAIXA - PORCENTAGEM
	 * 
	 * @return a representação em String do casino
	 */
	public String toString() {
		return this.caixa + " - " + this.porcentagem;
	}
}
