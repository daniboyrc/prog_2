package casino;

import java.util.ArrayList;

/**
 * Classe que representa um cenário de apostas no Casino
 * 
 * @author daniel
 */
public class Cenario {
	private int id;
	private String descricao;
	private ArrayList<Aposta> apostas;
	private String finalizado;
	private int valorArrecadado;
	
	/**
	 * Cadastra cenário a partir da descrição da aposta 
	 * e do identificador do cenário.
	 * 
	 * @param descricao a descrição da aposta
	 * @param id o identificador do cenário
	 */
	public Cenario(String descricao, int id) {
		if (descricao == null) {
			throw new NullPointerException("Valor nulo");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		} else if (id <= 0) {
			throw new IllegalArgumentException("Valor menor ou igual a 0");
		}
		
		this.descricao = descricao;
		this.apostas = new ArrayList<Aposta>();
		this.finalizado = "Nao finalizado";
		this.id = id;
	} 	
	
	/**
	 * Cadastra uma aposta através do nome do apostador, do valor apostado
	 * e da previsão do apostador.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor apostado
	 * @param previsao a previsão do apostador
	 */
	public void cadastraAposta(String apostador, int valor, String previsao) {
		try {
			this.apostas.add(new Aposta(apostador, valor, previsao));
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Retorna o valor total apostado no cenário.
	 * 
	 * @return o valor total de apostas no cenário
	 */
	public int valorApostas() {
		int valor = 0;
		for (Aposta apt : this.apostas) {
			valor += apt.getValor();
		}
		return valor;
	}
	
	/**
	 * Retorna a quantidade de apostas do cenário.
	 * 
	 * @return o valor total de apostas no cenário
	 */
	public int totalApostas() {
		return this.apostas.size();
	}
	
	/**
	 * Retorna a lista de apostas feitas no cenário.
	 * 
	 * @return a lista de apostas
	 */
	public String listaApostas() {
		String lista = "";
		for (Aposta apt : this.apostas) {
			lista += apt.toString() + System.lineSeparator();
		}
		return lista;
	}
	
	/**
	 * Encerra o cenário .
	 * 
	 * @param cenario o identificador do cenário
	 * @param veredito o resultado do cenário 
	 */
	public void fecharAposta(boolean veredito) {
		if (this.finalizado.equals("Finalizado")){
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		this.finalizado = "Finalizado";
		for (Aposta apt : this.apostas) {
			if (apt.getPrevisao() != veredito) {
				this.valorArrecadado += apt.getValor();
			}
		}
	}
	
	/**
	 * Retorna o valor a ser distribuido entre os vencedores.
	 * 
	 * @param porcentagem a porcentagem do casino
	 * @return o valor a ser distribuido entre os vencedores
	 */
	public int valorParaDistribuir(double porcentagem) {
		if (this.finalizado.equals("Nao finalizado")){
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		
		return (int) (Math.floor(this.valorArrecadado * (1 - porcentagem)));
	}
	
	/**
	 * Retorna o valor que irá para o caixa do casino
	 * 
	 * @param porcentagem a porcentagem do casino
	 * @return o valor que irá para o caixa do casino
	 */
	public int valorParaCaixa(double porcentagem) {
		if (this.finalizado.equals("Nao finalizado")){
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return (int) (Math.floor(this.valorArrecadado * porcentagem));
	}
	
	/**
	 * Retorna a representação em String do cenário.
	 * Segue o formato: ID - DESCRICAO - FINALIZADO
	 * 
	 * @return a representação em String do cenário
	 */
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.finalizado; 
	}
}
