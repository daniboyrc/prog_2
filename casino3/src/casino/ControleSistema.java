package casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe de controle do Sistema de Casino
 * 
 * @author daniel
 */
public class ControleSistema {
	
	private static final String ORDEM_CADASTRO = "Cadastro";
	private static final String ORDEM_NOME = "Nome";
	private static final String ORDEM_APOSTAS = "Apostas";
	private Casino casino;
	private ArrayList<Cenario> cenarios;
	private Comparator<Cenario> comparador;
	
	/**
	 * Inicializa o sistema criando um casino a partir do
	 * valor de caixa inicial a da porcentagem cobrada por cenário.
	 * 
	 * @param caixa o valor de caixa inicial
	 * @param porcentagem a porcentagem cobrada por cenário
	 */
	public void inicializaSistema(int caixa, double porcentagem) {
		casino = new Casino(caixa, porcentagem);
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
	 * Cadastra cenário bônus a partir da descrição da aposta,
	 * do identificador e do bônus do cenário 
	 * e retorna esse identificador.
	 * 
	 * @param descricao a descrição da aposta
	 * @param id o identificador do cenário
	 * @param bonus o bônus do cenário
	 * @return o identificador do cenário
	 */
	public int cadastraCenario(String descricao, int bonus) {
		int id = this.cenarios.size() + 1;
		this.casino.retiraCaixa(bonus);
		this.cenarios.add(new CenarioBonus(descricao, id, bonus));
		
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
	 * nome do apostador, do valor apostado e da previsão.
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
		this.cenarios.get(cenario - 1).cadastraAposta(apostador, valor, previsao);
	}
	
	/**
	 * Cadastra uma nova aposta assegurada por valor no cenário especificado através 
	 * do nome do apostador, do valor apostado, da previsão, do valor assegurado,
	 * do custo do seguro e do id do cenário.
	 * 
	 * @param cenario o id do cenário
	 * @param apostador o nome do apostador
	 * @param valor o valor apostado
	 * @param previsao a previsão da aposta
	 * @param valorSeguro o valor a ser assegurado
	 * @param custo o custo do seguro
	 * @return o id da aposta
	 */
	public int cadastraApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}
		this.casino.somaCaixa(custo);
		return this.cenarios.get(cenario - 1).cadastraApostaSeguradaValor(apostador, valor, previsao, valorSeguro);
	}	
	
	/**
	 * Cadastra uma nova aposta assegurada por taxa no cenário especificado através 
	 * do nome do apostador, do valor apostado, da previsão, da taxa assegurada,
	 * do custo do seguro e do id do cenário.
	 * 
	 * @param cenario
	 * @param apostador
	 * @param valor
	 * @param previsao
	 * @param taxaSeguro
	 * @param custo
	 * @return
	 */
	public int cadastraApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxaSeguro,
			int custo) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		this.casino.somaCaixa(custo);
		return this.cenarios.get(cenario - 1).cadastraApostaSeguradaTaxa(apostador, valor, previsao, taxaSeguro);
	}	
	
	/**
	 * Altera o tipo de seguro para seguro por valor. Não há custos na transição.
	 * 
	 * @param cenario o id do cenario
	 * @param apostaAssegurada o id da aposta
	 * @param valor o valor do seguro
	 */
	public void alteraSeguroValor(int cenario, int apostaAssegurada, int valor) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.cenarios.get(cenario-1).alteraSeguroValor(apostaAssegurada, valor);
	}
	
	/**
	 * Altera o tipo de seguro para seguro por taxa. Não há custos na transição.
	 * 
	 * @param cenario o id do cenário
	 * @param apostaAssegurada o id da aposta
	 * @param taxa a taca do seguro
	 */
	public void alteraSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.cenarios.get(cenario-1).alteraSeguroTaxa(apostaAssegurada, taxa);
		
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
		this.casino.retiraCaixa(this.cenarios.get(cenario-1).valorDescontoSeguros());
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

	/**
	 * Altera o tipo de ordenação do sistema. O sistema pode ser
	 * ordenado por: "Cadastro", "Nome" ou "Aposta".
	 * 
	 * @param ordem o tipo de ordenação
	 */
	public void alterarOrdem(String ordem) {
		if (ordem.equals(ORDEM_CADASTRO)) {
			this.comparador = new ComparaCadastro();
		} else if (ordem.equals(ORDEM_NOME)) {
			this.comparador = new ComparaNome();
		} else if (ordem.equals(ORDEM_APOSTAS)) {
			this.comparador = new ComparaAposta();
		} else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Tipo de Ordenação inválida");
		}
	}

	/**
	 * Lista os cenários de acordo com o tipo de ordenação do
	 * sistema.
	 * 
	 * @return uma lista de cenários ordenados
	 */
	public String exibirCenarioOrdenado() {
		if (this.comparador == null) {
			throw new IllegalArgumentException("Erro ao listar ordenado: Tipo de Ordenação não informada");
		}
		String listaCenarios = "";
		
		Collections.sort(this.cenarios, this.comparador);
		for (Cenario c : this.cenarios) {
			listaCenarios += c.toString() + System.lineSeparator();
		}
		
		return listaCenarios;
	}

}
