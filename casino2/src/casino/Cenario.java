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
	protected int valorArrecadado;
	private boolean veredito;
	
	/**
	 * Constrói cenário a partir da descrição da aposta 
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
	 * Retorna o id do cenário para a classe filha.
	 * 
	 * @return o id do cenário
	 */
	protected int getId() {
		return this.id;
	}
	
	/**
	 * Retorna a descrição do cenário para a classe filha.
	 * 
	 * @return a descrição do cenário
	 */
	protected String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Retorna o status de finalização do cenário para a classe filha.
	 * 
	 * @return o status de finalização do cenário
	 */
	protected String getFinalizado() {
		return this.finalizado;
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
	 * Cadastra uma aposta assegurada através do nome do apostador, 
	 * do valor apostado, da previsão do apostador e do valor do seguro.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor apostado
	 * @param previsao a previsão do apostador
	 * @param valorSeguro o valor a ser assegurado
	 * @return o id da aposta
	 */
	public int cadastraApostaSeguradaValor(String apostador, int valor, String previsao,
			int valorSeguro) {
		this.apostas.add(new Aposta(apostador, valor, previsao, valorSeguro));
		return apostas.size() - 1;
	}
	
	/**
	 * Cadastra uma aposta assegurada através do nome do apostador, 
	 * do valor apostado, da previsão do apostador e da taxa assegurada.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor da aposta
	 * @param previsao a previsão do apostador
	 * @param taxaSeguro a taxa a ser assegurada
	 * @return o id da aposta
	 */
	public int cadastraApostaSeguradaTaxa(String apostador, int valor, String previsao,
			double taxaSeguro) {
		this.apostas.add(new Aposta(apostador, valor, previsao, taxaSeguro));
		return apostas.size() - 1;
	}
	
	/**
	 * Altera o tipo de seguro para seguro do tipo valor.
	 * 
	 * @param apostaAssegurada o id da aposta
	 * @param valor o valor assegurado
	 */
	public void alteraSeguroValor(int apostaAssegurada, int valor) {
		this.apostas.get(apostaAssegurada).alteraSeguroValor(valor);	
	}
	
	/**
	 * Altera o tipo de seguro para seguro do tipo taxa.
	 * 
	 * @param apostaAssegurada o id da aposta
	 * @param taxa a taxa assegurada
	 */
	public void alteraSeguroTaxa(int apostaAssegurada, double taxa) {
		this.apostas.get(apostaAssegurada).alteraSeguroTaxa(taxa);
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
		this.veredito = veredito;
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
		} else if (porcentagem < 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Porcentagem menor que 0");
		} else if (porcentagem > 1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Porcentagem maior que 1");
		}
		
		return (int) (Math.ceil(this.valorArrecadado * (1 - porcentagem)));
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
		} else if (porcentagem < 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Porcentagem menor que 0");
		} else if (porcentagem > 1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Porcentagem maior que 1");
		}
		return (int) (Math.floor(this.valorArrecadado * porcentagem));
	} 
	
	/**
	 * Retorna o valor total dos seguros a serem descontados do caixa.
	 * 
	 * @return o valor total dos seguros a serem decontados
	 */
	public int valorDescontoSeguros() {
		int desconto = 0;
		
		for (Aposta apt : this.apostas) {
			if (apt.getPrevisao() != this.veredito) {
				if (apt.existeSeguro()) {
					desconto += apt.getSeguroValor();
				}
			}
		}
		
		return desconto;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
