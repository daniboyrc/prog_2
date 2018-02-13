package casino;

public class CenarioBonus extends Cenario{
	private int bonus;
	
	/**
	 * Constrói cenário bonus a partir da descrição da aposta,
	 * do identificador do cenário e do bonus.
	 * 
	 * @param descricao a descrição da aposta
	 * @param id o identificador do cenário
	 * @param bonus o bonus do cenário
	 */
	CenarioBonus(String descricao, int id, int bonus){
		super(descricao, id);
		
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}	
		this.bonus = bonus;
	}
	
	/**
	 * Retorna o valor a ser distribuido entre os vencedores.
	 * 
	 * @param porcentagem a porcentagem do casino
	 * @return o valor a ser distribuido entre os vencedores
	 */
	@Override
	public int valorParaDistribuir(double porcentagem) {
		if (this.getFinalizado().equals("Nao finalizado")){
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		} else if (porcentagem < 0 || porcentagem > 1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Porcentagem menor que 0");
		} else if (porcentagem > 1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Porcentagem maior que 1");
		}
		
		return (int) (Math.ceil(this.valorArrecadado * (1 - porcentagem) + this.bonus));
	}
	
	/**
	 * Retorna a representação em String do cenário bônus.
	 * Segue o formato: ID - DESCRICAO - FINALIZADO - BONUS
	 * 
	 * @return a representação em String do cenário
	 */
	public String toString() {
		return this.getId() + " - " + this.getDescricao() + " - " + this.getFinalizado() + " - R$ " + this.bonus / 100 + ",00"; 
	}
}
