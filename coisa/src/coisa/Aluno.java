package coisa;

import java.util.ArrayList;

/**
 * Representação de um estudante matriculado da UFCG, especificamente de
 * computação.
 *
 * @author Daniel Coura
 */
public class Aluno {
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<ContaLaboratorio> contasLaboratorio;
	private ArrayList<ContaCantina> contasCantina;
	private Saude saude = new Saude();
	
    /**
     * Constrói um aluno.
     * Todo aluno começa com as listas de discplinas, contas de laboratótio
     * e contas de cantina vazios.
     */
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.contasLaboratorio = new ArrayList<ContaLaboratorio>();
		this.contasCantina = new ArrayList<ContaCantina>();	
	}
	
	/**
     * Pesquisa o índice da conta de laboratório que tem como nome 
     * a string passada.
     * 
     * @param nome o nome do laboratório.
     * @returns o índice do laboratório.
     */
	private int indiceLaboratorio(String nome) {
		for (int i = 0; i < this.contasLaboratorio.size(); i++) {
			if (nome.equals(this.contasLaboratorio.get(i).getNomeLaboratorio())){
				return i;
			}
		}
		return -1;
	}
	
	/**
     * Pesquisa o índice da disciplina que tem como nome 
     * a string passada.
     * 
     * @param nome o nome da disciplina.
     * @returns o índice da disciplina.
     */
	private int indiceDisciplina(String nome) {
		for (int i = 0; i < this.disciplinas.size(); i++) {
			if (nome.equals(disciplinas.get(i).getNomeDisciplina())){
				return i;
			}
		}
		return -1;
	}
	
	/**
     * Pesquisa o índice da conta da cantina que tem como nome 
     * a string passada.
     * 
     * @param nome o nome da cantina.
     * @returns o índice da cantina.
     */
	private int indiceCantina(String nome) {
		for (int i = 0; i < this.contasCantina.size(); i++) {
			if (nome.equals(contasCantina.get(i).getNomeCantina())){
				return i;
			}
		}
		return -1;
	}
	
	/**
     * Cadastra laboratório a patir do nome e cota. 
     * 
     * @param nomeLaboratorio o nome do laboratório.
     * @param cota a capacidade de armazenamento em MB do laboratório.
     */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.contasLaboratorio.add(new ContaLaboratorio(nomeLaboratorio, cota));
		System.out.printf("Laboratório %s com cota %d cadastrado com sucesso\n", nomeLaboratorio, cota);
	}
	
	/**
     * Cadastra laboratório a partir do nome e cota padrão de 2000 MB.
     * 
     * @param nomeLaboratorio o nome do laboratório.
     */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		cadastraLaboratorio(nomeLaboratorio, 2000);
	}
	
	/**
     * Consome espaço de armazenamento do laboratório especificado.
     * 
     * @param nomeLaboratorio o nome do laboratório a ser manipulado.
     * @param mbytes a quantidade de MBs a ser ocupado.
     */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).consomeEspaco(mbytes);
		System.out.printf("Espaço de %d MB consumidos em %s\n", mbytes, nomeLaboratorio);
	}
	
	/**
     * Libera espaço de armazenamento do laboratório especificado.
     * 
     * @param nomeLaboratorio o nome do laboratório a ser manipulado.
     * @param mbytes a quantidade de MBs a ser desocupada.
     */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).liberaEspaco(mbytes);
		System.out.printf("Espaço de %d MB liberados em %s\n", mbytes, nomeLaboratorio);
	}
	
	/**
     * Verifica se o laboratório especificado atingiu a cota de armazenamento.
     * 
     * @param nomeLaboratorio o nome do laboratório a ser manipulado.
     * @return booleano indicando se passou ou não da cota.
     */
	public boolean atingiuCota(String nomeLaboratorio) {
		return this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).atingiuCota();
	}
	
	/**
     * Retorna String que representa o laboratório.
     * 
     * @return representação em String do laboratório.
     */
	public String laboratorioToString(String nomeLaboratorio) {
		return this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).toString();
	}
	
	/**
     * Retorna lista das representações em String do laboratórios 
     * que o aluno tem conta.
     * 
	 * @return String da lista de laboratórios que o aluno tem conta.
     */
	public String listaLab() {
		String lista = "";
		for (ContaLaboratorio i : this.contasLaboratorio) {
			lista += i.toString() + "\n";
		}
		return lista;
	}
	
	/**
     * Cadastra disciplina que o aluno está cursando através do nome, 
     * número de notas e pesos das notas.
     * 
     * @param nomeDisciplina o nome da disciplina a ser cadastrada.
     * @param numNotas quantidade de notas da disciplina.
     * @param peso de cada nota. 
     */
	public void cadastraDisciplina(String nomeDisciplina, int numNotas, int[] pesos) {
		this.disciplinas.add(new Disciplina(nomeDisciplina, numNotas, pesos));
		System.out.printf("Disciplina %s com %d notas e pesos {", nomeDisciplina, numNotas);
		for (int i : pesos) {
			System.out.printf("%d, ", i);
		}
		System.out.println("}cadastrada com sucesso!");
	}
	
	/**
     * Cadastra disciplina que o aluno está cursando através do nome, 
     * e numero de notas. Pesos padrão.
     * 
     * @param nomeDisciplina o nome da disciplina a ser cadastrada.
     * @param numNotas quantidade de notas da disciplina.
     */
	public void cadastraDisciplina(String nomeDisciplina, int numNotas) {
		this.disciplinas.add(new Disciplina(nomeDisciplina, numNotas));
		System.out.printf("Disciplina %s com %d notas cadastrada com sucesso\n", nomeDisciplina);
	}
	
	/**
     * Cadastra disciplina que o aluno está cursando através do nome. 
     * Número de notas e pesos padrão
     * 
     * @param nomeDisciplina o nome da disciplina a ser cadastrada.
     */
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplinas.add(new Disciplina(nomeDisciplina));
		System.out.printf("Disciplina %s cadastrada com sucesso\n", nomeDisciplina);
	}
	
	/**
     * Cadastra horas cursadas na disciplina informada.
     * 
     * @param nomeDisciplina o nome da disciplina a ser manipulada.
     * @param horas a quantidade de horas cursadas.
     */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		this.disciplinas.get(indiceDisciplina(nomeDisciplina)).cadastraHoras(horas);
		System.out.printf("%d horas cadastradas na disciplina %s\n", horas, nomeDisciplina);
	}
	
	/**
     * Cadastra nota na disciplina informada, através do nome da disciplina,
     * a nota a ser cadastrada e o valor dessa nota.
     * 
     * @param nomeDisciplina o nome da disciplina a ser manipulada.
     * @param nota a nota a ser cadastrada.
     * @param valorNota o novo valor da nota.
     */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		this.disciplinas.get(indiceDisciplina(nomeDisciplina)).cadastraNota(nota, valorNota);
		System.out.printf("Nota %d de valor %f na disciplina %s\n", nota, valorNota, nomeDisciplina);
	}
	
	/**
     * Verifica se o aluno foi aprovado. Só será aprovado se a média
     * das notas for maior ou igual a 7.
     * 
     * @param nomeDisciplina o nome da disciplina a ser manipulada.
	 * @return Booleano indicando se foi aprovado.
     */
	public boolean aprovado(String nomeDisciplina) {
		return this.disciplinas.get(indiceDisciplina(nomeDisciplina)).aprovado();
	}
	
	/**
     * Representação em String da disciplina informada.
     * 
     * @param nomeDisciplina o nome da disciplina que deseja ver a representação.
     * @return a representação em String da disciplina.
     */
	public String disciplinaToString(String nomeDisciplina) {
		return this.disciplinas.get(indiceDisciplina(nomeDisciplina)).toString();
	}
	
	/**
     * Cadastra conta da cantina através do nome informado.
     * 
     * @param nomeCantina o nome da cantina a ser cadastada.
     */
	public void cadastraCantina(String nomeCantina) {
		this.contasCantina.add(new ContaCantina(nomeCantina));
		System.out.printf("Cantina %s cadastrada com sucesso\n", nomeCantina);
	}
	
	/**
     * Cadastra lache comprado na cantina informada.
     * 
     * @param nomeCantina o nome da cantina a ser manipulada
     * @param qtdItens a quantidade de itens consumida
     * @param valorCentavos o preço total do lanche
     * @param detalhes uma obsercação sobre o lanche
     */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos, String detalhes) {
		this.contasCantina.get(indiceCantina(nomeCantina)).cadastraLanche(qtdItens, valorCentavos, detalhes);
		System.out.printf("%d lanches de valor %d na cantina %s\n", qtdItens, valorCentavos, nomeCantina);
	}
	
	/**
     * Cadastra lache comprado na cantina informada.
     * 
     * @param nomeCantina o nome da cantina a ser manipulada
     * @param qtdItens a quantidade de itens consumida
     * @param valorCentavos o preço total do lanche
     */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		this.cadastraLanche(nomeCantina, qtdItens, valorCentavos, null);
	}
	
	/**
     * Paga total ou parcialmente a conta da cantina informada.
     * 
     * @param nomeCantina o nome da cantina a ser manipulada.
     * @param valorCentavos valor que será pago.
     */
	
	public String listarDetalhes(String nomeCantina){
		return this.contasCantina.get(this.indiceCantina(nomeCantina)).listarDetalhes();
	}
	
	public void pagarConta(String nomeCantina, int valorCentavos) {
		this.contasCantina.get(indiceCantina(nomeCantina)).pagaConta(valorCentavos);
		System.out.printf("%d pagos na cantina %s\n", valorCentavos, nomeCantina);
	}
	
	/**
     * Retorna a String que representa a cantina informada. A representação segue o formato
     * "NOME_CANTINA QUANTIDADE_ITENS DÉBITO"
     * 
     * @param nomeCantina o nome da cantina a ser representada.
     * @return a String que representa a cantina 
     */
	public String cantinaToString(String nomeCantina) {
		int indice = indiceCantina(nomeCantina);
		return this.contasCantina.get(indice).toString();
	}
	
	/**
     * Altera a saúde mental do aluno. Pode assumir os valores
     * "boa", "ok" e "fraca"
     * 
     * @param valor a saúde mental.
     */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
		System.out.printf("Sua saúde mental está %s!", valor);
	}
	
	/**
     * Altera a saúde física do aluno. Pode assumir os valores
     * "boa", "ok" e "fraca"
     * 
     * @param valor a saúde física.
     */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
		System.out.printf("Sua saúde física está %s!", valor);
	}
	
	/**
     * Retorna a saúde geral do aluno, se baseia na saúde física e mental. Pode retornar
     * "boa", "ok" e "fraca"
     * 
     * @return a saúde geral do aluno.
     */
	public String geral() {
		return this.saude.geral();
	}
}
