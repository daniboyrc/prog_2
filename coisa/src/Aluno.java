package coisa;

import java.util.ArrayList;

/**
 * Representação de um estudante matriculado na UFCG, especificamente de
 * computacao.
 *
 * @author Daniel Coura
 */
public class Aluno {
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<ContaLaboratorio> contasLaboratorio;
	private ArrayList<ContaCantina> contasCantina;
	private Saude saude = new Saude();
	
    /**
     * Constroi um aluno.
     * Todo aluno comeca com as listas de discplinas, contas de laboratotio
     * e contas de cantina vazios.
     */
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.contasLaboratorio = new ArrayList<ContaLaboratorio>();
		this.contasCantina = new ArrayList<ContaCantina>();	
	}
	
	/**
     * Pesquisa o indice da conta de laboratorio que tem como nome 
     * a string passada. Caso nao encontre, retorna -1.
     * 
     * @param nome o nome do laboratorio.
     * @returns o indice do laboratorio ou -1, caso nao encontre.
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
     * Pesquisa o indice da disciplina que tem como nome 
     * a string passada. Caso nao encontre, retorna -1.
     * 
     * @param nome o nome da disciplina.
     * @returns o índice da disciplina ou -1, caso nao encontre.
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
     * Pesquisa o indice da conta da cantina que tem como nome 
     * a string passada. Caso nao encontre, retorna -1.
     * 
     * @param nome o nome da cantina.
     * @returns o índice da cantina, ou -1 caso nao encontre.
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
     * Cadastra laboratorio a patir do nome e cota. 
     * 
     * @param nomeLaboratorio o nome do laboratorio.
     * @param cota a capacidade de armazenamento em MB do laboratorio.
     */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.contasLaboratorio.add(new ContaLaboratorio(nomeLaboratorio, cota));
		System.out.printf("Laboratório %s com cota %d cadastrado com sucesso\n", nomeLaboratorio, cota);
	}
	
	/**
     * Cadastra laboratorio a partir do nome e cota padrao de 2000 MB.
     * 
     * @param nomeLaboratorio o nome do laboratorio.
     */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		cadastraLaboratorio(nomeLaboratorio, 2000);
	}
	
	/**
     * Consome espaco de armazenamento do laboratório especificado.
     * 
     * @param nomeLaboratorio o nome do laboratorio a ser manipulado.
     * @param mbytes a quantidade em MBs a ser ocupado.
     */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).consomeEspaco(mbytes);
		System.out.printf("Espaço de %d MB consumidos em %s\n", mbytes, nomeLaboratorio);
	}
	
	/**
     * Libera espaco de armazenamento do laboratorio especificado.
     * 
     * @param nomeLaboratorio o nome do laboratorio a ser manipulado.
     * @param mbytes a quantidade em MBs a ser liberado.
     */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).liberaEspaco(mbytes);
		System.out.printf("Espaço de %d MB liberados em %s\n", mbytes, nomeLaboratorio);
	}
	
	/**
     * Verifica se o laboratorio especificado atingiu a cota de armazenamento.
     * 
     * @param nomeLaboratorio o nome do laboratorio a ser verificado.
     * @return booleano indicando se passou ou nao da cota de armazenamento.
     */
	public boolean atingiuCota(String nomeLaboratorio) {
		return this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).atingiuCota();
	}
	
	/**
     * Retorna String que representa o laboratorio. a representacao segue
     * o formato: NOME_LABORATORIO - ESPACO_OCUPADO/COTA.
     * 
     * @return representacao em String do laboratorio.
     */
	public String laboratorioToString(String nomeLaboratorio) {
		return this.contasLaboratorio.get(indiceLaboratorio(nomeLaboratorio)).toString();
	}
	
	/**
     * Retorna lista das representacoes em String do laboratrios 
     * que o aluno tem conta.
     * 
	 * @return uma String da lista de laboratórios que o aluno tem conta.
     */
	public String listaLab() {
		String lista = "";
		for (ContaLaboratorio i : this.contasLaboratorio) {
			lista += i.toString() + "\n";
		}
		return lista;
	}
	
	/**
     * Cadastra disciplina que o aluno esta cursando atraves do nome, 
     * numero de notas e pesos das notas.
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
     * Cadastra disciplina que o aluno esta cursando atraves do nome 
     * e numero de notas. Peso padrao de 1, para cada nota.
     * 
     * @param nomeDisciplina o nome da disciplina a ser cadastrada.
     * @param numNotas quantidade de notas da disciplina.
     */
	public void cadastraDisciplina(String nomeDisciplina, int numNotas) {
		this.disciplinas.add(new Disciplina(nomeDisciplina, numNotas));
		System.out.printf("Disciplina %s com %d notas cadastrada com sucesso\n", nomeDisciplina);
	}
	
	/**
     * Cadastra disciplina que o aluno esta cursando atraves do nome. 
     * 4 notas por padrao e peso padrao de 1, para cada nota.
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
     * Cadastra nota na disciplina informada, atraves do nome da disciplina,
     * a nota a ser cadastrada e o valor dessa nota.
     * 
     * @param nomeDisciplina o nome da disciplina a ser manipulada.
     * @param nota a nota a ser cadastrada.
     * @param valorNota o valor da nota.
     */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		this.disciplinas.get(indiceDisciplina(nomeDisciplina)).cadastraNota(nota, valorNota);
		System.out.printf("Nota %d de valor %f na disciplina %s\n", nota, valorNota, nomeDisciplina);
	}
	
	/**
     * Verifica se o aluno foi aprovado. So sera aprovado se a media
     * das notas for maior ou igual a 7.
     * 
     * @param nomeDisciplina o nome da disciplina a ser verificada.
	 * @return um booleano indicando se foi aprovado.
     */
	public boolean aprovado(String nomeDisciplina) {
		return this.disciplinas.get(indiceDisciplina(nomeDisciplina)).aprovado();
	}
	
	/**
     * Representacao em String da disciplina informada.
     * 
     * @param nomeDisciplina o nome da disciplina que deseja ver a representacao.
     * @return a representacao em String da disciplina.
     */
	public String disciplinaToString(String nomeDisciplina) {
		return this.disciplinas.get(indiceDisciplina(nomeDisciplina)).toString();
	}
	
	/**
     * Cadastra conta da cantina atraves do nome informado.
     * 
     * @param nomeCantina o nome da cantina a ser cadastada.
     */
	public void cadastraCantina(String nomeCantina) {
		this.contasCantina.add(new ContaCantina(nomeCantina));
		System.out.printf("Cantina %s cadastrada com sucesso\n", nomeCantina);
	}
	
	/**
     * Cadastra lache comprado na cantina informada, a partir da quantidade de itens,
     * valor, e detalhes do lanche. Cada palavra em "detalhes" deve ser separada
     * por "_" (underscore).
     * 
     * @param nomeCantina o nome da cantina a ser manipulada
     * @param qtdItens a quantidade de itens consumida
     * @param valorCentavos o preco total do lanche
     * @param detalhes uma observacao sobre o lanche
     */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos, String detalhes) {
		this.contasCantina.get(indiceCantina(nomeCantina)).cadastraLanche(qtdItens, valorCentavos, detalhes);
		System.out.printf("%d lanches de valor %d na cantina %s\n", qtdItens, valorCentavos, nomeCantina);
	}
	
	/**
     * Cadastra lache comprado na cantina informada, a partir da quantidade de itens
     * e do valor.
     * 
     * @param nomeCantina o nome da cantina a ser manipulada
     * @param qtdItens a quantidade de itens consumida
     * @param valorCentavos o preco total do lanche
     */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		this.contasCantina.get(indiceCantina(nomeCantina)).cadastraLanche(qtdItens, valorCentavos);
		System.out.printf("%d lanches de valor %d na cantina %s\n", qtdItens, valorCentavos, nomeCantina);
	}
	
	/**
	 * Lista os detalhes dos ultimos 5 lanches consumidos.
	 * 
	 * @param nomeCantina
	 * @return a String da lista de detalhes
	 */
	public String listarDetalhes(String nomeCantina){
		return this.contasCantina.get(this.indiceCantina(nomeCantina)).listarDetalhes();
	}
	
	/**
     * Paga total ou parcialmente a conta da cantina informada.
     * 
     * @param nomeCantina o nome da cantina a ser manipulada.
     * @param valorCentavos valor que sera pago.
     */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		this.contasCantina.get(indiceCantina(nomeCantina)).pagaConta(valorCentavos);
		System.out.printf("%d pagos na cantina %s\n", valorCentavos, nomeCantina);
	}
	
	/**
     * Retorna a String que representa a cantina informada. A representacao segue o formato
     * "NOME_CANTINA - QUANTIDADE_ITENS - DEBITO"
     * 
     * @param nomeCantina o nome da cantina a ser representada
     * @return a String que representa a cantina 
     */
	public String cantinaToString(String nomeCantina) {
		int indice = indiceCantina(nomeCantina);
		return this.contasCantina.get(indice).toString();
	}
	
	/**
     * Altera a saude mental do aluno. Pode assumir os valores
     * "boa", "ok" e "fraca"
     * 
     * @param valor a saude mental do aluno.
     */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
		System.out.printf("Sua saúde mental está %s!", valor);
	}
	
	/**
     * Altera a saude fisica do aluno. Pode assumir os valores
     * "boa", "ok" e "fraca"
     * 
     * @param valor a saude fisica do aluno.
     */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
		System.out.printf("Sua saúde física está %s!", valor);
	}
	
	/**
     * Retorna a saude geral do aluno. Se baseia na saude fisica e mental. Pode retornar
     * "boa", "ok" e "fraca"
     * 
     * @return a saude geral do aluno.
     */
	public String geral() {
		return this.saude.geral();
	}
}
