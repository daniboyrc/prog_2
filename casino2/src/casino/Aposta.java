package casino;

/**
 * Classe que representa a aposta de um jogador no casino
 * @author daniel coura
 */
public class Aposta {
	
	private String apostador;
	private int valor;
	private String previsao;
	private Seguro seguro;
	
	/**
	 * Constrói aposta a partir do nome do apostador, do valor da aposta
	 * e da previsão. A previsão está limitada a: "VAI ACONTECER" e
	 * "N VAI ACONTECER".
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor apostado
	 * @param previsao a previsão do apostador
	 */
	public Aposta(String apostador, int valor, String previsao) {
		if (apostador == null || apostador.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("N VAI ACONTECER") && !previsao.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	public Aposta(String apostador, int valor, String previsao, int valorSeguro) {
		this(apostador, valor, previsao);
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	public Aposta(String apostador, int valor, String previsao, double valorTaxa) {
		this(apostador, valor, previsao);
		this.seguro = new SeguroTaxa(valorTaxa, valor);
	}
	
	public void alteraSeguroValor(int valor) {
		SeguroValor seguro = (SeguroValor) this.seguro;
		seguro.setValor(valor);
	}
	
	public void alteraSeguroTaxa(double taxa) {
		SeguroTaxa seguro = (SeguroTaxa) this.seguro;
		seguro.setTaxa(taxa);
	}
	
	public int getSeguroValor() {
		return this.seguro.getValor();
	}
	
	public boolean getExisteSeguro() {
		return this.seguro != null;
	}
	

	/**
	 * Retorna o valor da aposta.
	 * 
	 * @return o valor da aposta
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna a previsão da aposta. Se a previsão for
	 * "VAI ACONTECER" retorna true. Se a previsão for
	 * "N VAI ACONTECER" retorna false.
	 * 
	 * @return o bolleano que representa a previsao
	 */
	public boolean getPrevisao() {
		return this.previsao.equals("VAI ACONTECER");
	}
	
	/**
	 * Retorna a representação em String da resposta. Segue o fomato:
	 * NOME - VALOR - PREVISAO
	 */
	public String toString() {
		return this.apostador + " - " + this.valor + " - " + this.previsao;
	}
}
