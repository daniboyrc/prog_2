package coisa;

<<<<<<< HEAD
/**
* Representação da conta de uma cantina que será 
* atribuída a um estudante.
*
* @author Daniel Coura
*/
=======
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
public class ContaCantina {
	private String nomeCantina;
	private int debito;
	private int qtdItens;
	private String[] detalhes = new String[5];
	private int qtdDetalhes;
	
<<<<<<< HEAD
	/**
     * Constrói uma cantina.
     * Toda cantina começa com debito, quantidade de itens
     * e detalhes vazios.
     * 
     * @param o nome da cantina
     */
=======
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
<<<<<<< HEAD
	/**
	 * Retorna o nome da cantina.
	 *  
	 * @return o nome da cantina
	 */
=======
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
	public String getNomeCantina() {
		return this.nomeCantina;
	}
	
<<<<<<< HEAD
	/**
	 * Cadastra lanche comprado através da quantidade de itens,
	 * valor total em centavos e detalhe do lanche.
	 * 
	 * @param qtdItens a quantidade de itens consumidos
	 * @param valorCentavos o valor total do lanche em centavos
	 * @param detalhe uma observação sobre o lanche consumido 
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhe) {
		  this.qtdItens += qtdItens;
		  this.debito += valorCentavos;
		  if (detalhe != null) {
			  this.adicionaDetalhe(detalhe);
		  }
	}
	
	/**
	 * Cadastra lanche comprado através da quantidade de itens e 
	 * do valor total em centavos.
	 * 
	 * @param qtdItens a quantidade de itens consumidos
	 * @param valorCentavos o valor total do lanche em centavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		  this.cadastraLanche(qtdItens, valorCentavos, null);
	}
	
	/**
	 * Adiciona detalhe do lanche no array detalhes.
	 * Se o tamanho do array passar de 5, o método remove
	 * o primeiro detalhe passado e adiciona o novo.
	 * 
	 * @param detalhe uma observação do lanche consumido
	 */
	private void adicionaDetalhe(String detalhe) {
=======
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		  this.qtdItens += qtdItens;
		  this.debito += valorCentavos;
	}

	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhe) {
		  this.qtdItens += qtdItens;
		  this.debito += valorCentavos;
		  adicionaDetalhe(detalhe);
	}
	
	public void adicionaDetalhe(String detalhe) {
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
		if (this.qtdDetalhes == 5) {
			String[] arrayTmp = new String[5];
			for (int i = 0; i < 5; i++) {
				arrayTmp[i] = this.detalhes[i + 1];
			}
			arrayTmp[4] = detalhe;
			this.detalhes = arrayTmp;
		}
		this.qtdDetalhes += 1;
		this.detalhes[this.qtdDetalhes - 1] = detalhe;
	}
	
<<<<<<< HEAD
	/**
	 * Lista os últimos 5 detalhes dos lanches consumidos.
	 * 
	 * @return a lista de detalhes dos lanches
	 */
=======
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
	public String listarDetalhes() {
		String var = "";
		for (int i = 0; i < 5; i++) {
			var += this.detalhes[i] + ", ";
		}
		return var;
	}
	
<<<<<<< HEAD
	/**
	 * Desconta o valor em centavos do débito da conta da cantina.
	 * 
	 * @param valorCentavos o valor em centavos a ser descontado.
	 */
=======
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
	public void pagaConta(int valorCentavos) {
		this.debito -= valorCentavos;
	}
	
<<<<<<< HEAD
	/**
	 * Retorna a String que representa a conta da cantina. A representação
	 * segue o formato: "NOME_CANTINA - QUANTIDADE_ITENS - DEBITO"
	 * 
	 * @return a representação em String da cantina
	 */
	public String toString() {
		return this.nomeCantina + " - " + this.qtdItens + " - " + this.debito;
=======
	public String toString() {
		return this.nomeCantina + " " + this.qtdItens + " " + this.debito;
>>>>>>> 4fced17fcdfddf2f854a14e29b08ce9b9e214988
	}
}
