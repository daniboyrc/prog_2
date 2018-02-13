package casino;

import seguro.Seguro;
import seguro.SeguroTaxa;
import seguro.SeguroValor;

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
	
	/**
	 * Constrói aposta a partir do nome do apostador, do valor da aposta,
	 * da previsão e do valor assegurado. A previsão está limitada a: "VAI ACONTECER" e
	 * "N VAI ACONTECER".
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor da aposta
	 * @param previsao a previsão da aposta
	 * @param valorSeguro o valor a ser assegurado
	 */
	public Aposta(String apostador, int valor, String previsao, int valorSeguro) {
		if (apostador == null || apostador.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		} else if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("N VAI ACONTECER") && !previsao.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	/**
	 * Constrói aposta assa partir do nome do apostador, do valor da aposta,
	 * da previsão e da taxa assegurada. A previsão está limitada a: "VAI ACONTECER" e
	 * "N VAI ACONTECER".
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor da aposta
	 * @param previsao a previsão da aposta
	 * @param valorTaxa a taxa a ser assegurada
	 */
	public Aposta(String apostador, int valor, String previsao, double valorTaxa) {
		if (apostador == null || apostador.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		} else if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("N VAI ACONTECER") && !previsao.equals("VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SeguroTaxa(valorTaxa, valor);
	}
	
	/**
	 * Altera o tipo de seguro para seguro por valor.
	 * Não há custos nas transição.
	 * 
	 * @param valor o valor do seguro
	 */
	public void alteraSeguroValor(int valor) {
		this.seguro = new SeguroValor(valor);
	}
	
	/**
	 * Altera o tipo de seguro para seguro por taxa.
	 * Não há custos nas transição.
	 * 
	 * @param taxa a taxa do seguro
	 */
	public void alteraSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(taxa, this.valor);
	}
	
	/**
	 * Retorna o valor assegurado
	 * 
	 * @return um inteiro correspondente ao valor assegurado
	 */
	public int getSeguroValor() {
		return this.seguro.getValor();
	}
	
	/**
	 * Retorna se há ou não seguro
	 * 
	 * @return um booleano indicando a existencia de seguro
	 */
	public boolean existeSeguro() {
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
		String seguro = "";
		if (this.existeSeguro()){
			seguro = " - " + this.seguro.toString();
		}
		return this.apostador + " - " + this.valor + " - " + this.previsao + seguro;
	}
}
