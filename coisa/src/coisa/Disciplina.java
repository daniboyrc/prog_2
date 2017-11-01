package coisa;

/**
* Representação de uma disciplina a ser cursada por um estudante, especificamente de
* computação. 
* 
* @author Daniel Coura
*
*/
public class Disciplina {
	private String nomeDisciplina;
	private int horasTrabalhadas;
	private double[] notas;
	private int[] pesos;
	
	/**
    * Constrói uma disciplina a partir do nome, número de notas e peso de cada nota.
	*
	* @param nomeDisciplina o nome da disciplina.
	* @param numNotas a quantidade de notas da disciplina.
	* @param pesos o peso de cada nota da disciplina.
	*/
	public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[numNotas];
		this.pesos = pesos;
	}
	
	/**
    * Constrói uma disciplina a partir do nome e número de notas. Os pesos
 	* de cada nota são por padrão 1.
	*
	* @param nomeDisciplina o nome da disciplina.
	* @param numNotas a quantidade de notas da disciplina.
	*/
	public Disciplina(String nomeDisciplina, int numNotas) {
		this(nomeDisciplina, numNotas, new int[numNotas]);
		for (int i = 0; i < numNotas; i ++) {
			this.pesos[i] = 1;
		}
	}
	
	/**
    * Constrói uma disciplina a partir do nome. A quantidade de notas é por
	* padrão 4 e o peso de cada nota é 1.
	* 
	* @param nomeDisciplina o nome da disciplina.	
	*/
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4, new int[] {1, 1, 1, 1});
	}
	
	/**
    * Retorna o nome da disciplina.
    *
    * @returns a String do nome da disciplina.
    */
	public String getNomeDisciplina() {
		return this.nomeDisciplina;
	}
	
	/**
    * Cadastra a quantidade de horas cursadas na disciplina.
    *
    * @param horas as horas cursadas na disciplina.
    */
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas = horas;
	}
	
	/**
    * Cadastra nota na disciplina através da nota a ser cadastrada 
    * e o valor dessa nota.
    * 
    * @param nota a nota a ser alterada.
    * @param valorNota o novo valor da nota.
    */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
    * Retorna a média das notas da disciplina
    * 
    * @return a média das notas.
    */
	public double calculaMedia() {
		int soma = 0;
		for (int i = 0; i < this.pesos.length; i++) {
			soma += this.pesos[i];
		}
		double media = 0;
		for (int i = 0; i < this.notas.length; i++) {
			media += this.notas[i] * this.pesos[i] / soma;
		}
		return media;
	}
	
	/**
    * Verifica se o aluno foi aprovado. Só será aprovado se a média
    * das notas for maior ou igual a 7.
    * 
	* @return Booleano indicando se foi aprovado.
    */
	public boolean aprovado() {
		if (this.calculaMedia() >= 7) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
    * Representação em String da disciplina.
    * 
    * @return a representação em String da disciplina.
    */
	public String toString() {
		String notas = "";
		for (int i = 0; i < this.notas.length; i++) {
			notas += this.notas[i] + ", ";
		}
		return this.nomeDisciplina + " " + this.horasTrabalhadas + " " + 
	    this.calculaMedia() + " [" + notas + "]";
	}
}
