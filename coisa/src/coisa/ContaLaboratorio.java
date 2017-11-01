package coisa;

/**
* Representacao da conta de um laboratorio que sera 
* atribuida a um estudante.
*
* @author Daniel Coura
*/
public class ContaLaboratorio {
	private String nomeLaboratorio;
	private int espacoOcupado;
	private int cota;
	
	/**
	 * Constroi uma conta de laboratorio atraves do nome
	 * do laboartorio e da cota de armazenamento em MB.
	 * 
	 * @param nomeLaboratorio o nome do laboratorio
	 * @param cota a capacidade de armazenamento do laboratorio em MB
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Constroi uma conta de laboratorio atraves do nome
	 * do laboartorio. Cota de armazenamento igual a 2000 MB.
	 * 
	 * @param nomeLaboratorio o nome do laboratorio
	 * @param cota a capacidade de armazenamento do laboratorio
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}
	
	/**
	 * Retorna o nome do laboratorio.
	 * 
	 * @return o nome do laboratorio
	 */
	public String getNomeLaboratorio() {
		return this.nomeLaboratorio;
	}
	
	/**
	 * Consome o espaco de armazenamento do laboratorio.
	 * 
	 * @param mbytes a quantidade de MBs a ser ocupada
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * Libera o espaco de armazenamento do laboratorio.
	 * 
	 * @param mbytes a quantidade de MBs a ser liberada
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * Verifica se o aluno ultrapassou a cota de armazenamento.
	 * 
	 * @return um Booleano indicando se o aluno ultrapassou a cota
	 */
	public boolean atingiuCota() {
		return (this.espacoOcupado >= this.cota);
	}
	
	/**
	 * Retorna a representacao em string do laboratorio. A representacao segue
	 * o formato: NOME_LABORATORIO - ESPACO_OCUPADO/COTA.
	 * 
	 * @return a representacao em String do laboratorio
	 */
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}
