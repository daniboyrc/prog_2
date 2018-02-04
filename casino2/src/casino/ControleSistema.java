package casino;

import java.util.ArrayList;

/**
 * Classe de controle do Sistema de Casino
 * 
 * @author daniel
 */
public class ControleSistema {
	
	private Casino casino;
	private ArrayList<Cenario> cenarios;
	
	/**
	 * Inicializa o sistema criando um casino a partir do
	 * valor de caixa inicial a da porcentagem cobrada por cenário.
	 * 
	 * @param caixa o valor de caixa inicial
	 * @param porcentagem a porcentagem cobrada por cenário
	 */
	public void inicializaSistema(int caixa, double porcentagem) {
		try {
			casino = new Casino(caixa, porcentagem);
		} catch (Exception e) {
			throw e;
		}
		this.cenarios = new ArrayList<Cenario>();
	}
	
	/**
	 * Retorna o valor de caixa atual do casino.
	 * 
	 * @return o valor de caixa atual do casino
	 */
	public int getCaixa() {
		return this.casino.getCaixa();
	}
	
	/**
	 * Cadastra cenário a partir da descrição da aposta 
	 * e do identificador do cenário e retorna esse identificador.
	 * 
	 * @param descricao a descrição da aposta
	 * @param id o identificador do cenário
	 * @return o identificador do cenário
	 */
	public int cadastraCenario(String descricao) {
		int id = this.cenarios.size() + 1;
		this.cenarios.add(new Cenario(descricao, id));
		
		return id;
	}

	/**
	 * Método de validação do identificador do cenário.
	 * @param cenario o identificador do cenário
	 */
	private void validaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
	}
	
	/**
	 * Retorna a representação em String do cenário especificado.
	 * 
	 * @param cenario o identificador do cenário
	 * @return a representação em String do cenário
	 */
	public String getCenario(int cenario) {
		try {
			this.validaCenario(cenario);
		} catch (IllegalArgumentException iae){
			throw iae;
		}
		return this.cenarios.get(cenario - 1).toString();
	}
	
	/**
	 * Retorna a lista de cenários cadastrados no Casino.
	 * 
	 * @return a lista de cenário cadastrados
	 */
	public String listaCenarios() {
		String lista = "";
		for (Cenario cn : this.cenarios) {
			lista += cn.toString() + System.lineSeparator();
		}
		return lista;
	}
	
	/**
	 * Cadastra uma nova aposta no cenário especificado através do
	 * do nome do apostador, do valor apostado e da previsão.
	 * 
	 * @param cenario o identificador do cenário em que a aposta será cadastrada
	 * @param apostador o nome do apostador
	 * @param valor o valor apostado
	 * @param previsao a previsão do apostador
	 */
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		try {
			this.cenarios.get(cenario - 1).cadastraAposta(apostador, valor, previsao);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Retorna o valor total apostado no cenário informado.
	 * 
	 * @param cenario o identificador do cenário
	 * @return o valor total de apostas no cenário
	 */
	public int valorTotalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).valorApostas();
	}
	
	/**
	 * Retorna a quantidade de apostas feitas no cenário informado.
	 * 
	 * @param cenario o identificador do cenário
	 * @return a quantidade total de apostas no cenário
	 */
	public int totalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).totalApostas();
	}
	
	/**
	 * Listas as apostas feitas no cenário informado.
	 * 
	 * @param cenario o identificador do cenário
	 * @return a lista de apostas feitas no cenário
	 */
	public String listaApostas(int cenario) {
		try {
			this.validaCenario(cenario);
		} catch (IllegalArgumentException iae){
			throw iae;
		}
		return this.cenarios.get(cenario - 1).listaApostas();
	}
	
	/**
	 * Encerra o cenário passando o veredito do mesmo.
	 * 
	 * @param cenario o identificador do cenário
	 * @param veredito o resultado do cenário 
	 */
	public void fecharAposta(int cenario, boolean veredito) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		try {
			this.cenarios.get(cenario-1).fecharAposta(veredito);
		} catch (Exception e) {
			throw e;
		}
		this.casino.somaCaixa(this.cenarios.get(cenario-1).valorParaCaixa(this.casino.getPorcentagem()));
	}
	
	/**
	 * Retorna o valor a ser distribuído entre os vencedores.
	 * 
	 * @param cenario o identificador do cenário
	 * @return o valor a ser distribuído entre os vencedores
	 */
	public int getTotalRateioCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		int valor = 0;
		try {
			valor = this.cenarios.get(cenario-1).valorParaDistribuir(this.casino.getPorcentagem());
		} catch (Exception e) {
			throw e;
		}
		
		return valor;
	}
	
	/**
	 * Retorna o valor que irá para o caixa do casino.
	 * 
	 * @param cenario o identificador do cenário
	 * @return o valor que irá para o caixa do casino
	 */
	public int getTotalCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario-1).valorParaCaixa(this.casino.getPorcentagem());
	}	
}
