package coisa;

import java.util.ArrayList;

public class Aluno {
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<ContaLaboratorio> contasLaboratorio;
	private ArrayList<ContaCantina> contasCantina;
	private Saude saude = new Saude();
	
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.contasLaboratorio = new ArrayList<ContaLaboratorio>();
		this.contasCantina = new ArrayList<ContaCantina>();	
	}
	
	private int indiceLaboratorio(String palavra) {
		for (int i = 0; i < this.contasLaboratorio.size(); i++) {
			if (palavra.equals(this.contasLaboratorio.get(i).getNomeLaboratorio())){
				return i;
			}
		}
		return -1;
	}

	private int indiceDisciplina(String palavra) {
		for (int i = 0; i < this.disciplinas.size(); i++) {
			if (palavra.equals(disciplinas.get(i).getNomeDisciplina())){
				return i;
			}
		}
		return -1;
	}
	
	private int indiceCantina(String palavra) {
		for (int i = 0; i < this.contasCantina.size(); i++) {
			if (palavra.equals(contasCantina.get(i).getNomeCantina())){
				return i;
			}
		}
		return -1;
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.contasLaboratorio.add(new ContaLaboratorio(nomeLaboratorio));
		System.out.printf("Laboratório %s cadastrado com sucesso\n", nomeLaboratorio);
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.contasLaboratorio.add(new ContaLaboratorio(nomeLaboratorio, cota));
		System.out.printf("Laboratório %s com cota %d cadastrado com sucesso\n", nomeLaboratorio, cota);
	}
	
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		int indice = indiceLaboratorio(nomeLaboratorio);
		this.contasLaboratorio.get(indice).consomeEspaco(mbytes);
		System.out.printf("Espaço de %d MB consumidos em %s\n", mbytes, nomeLaboratorio);
	}
	
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		int indice = indiceLaboratorio(nomeLaboratorio);
		this.contasLaboratorio.get(indice).liberaEspaco(mbytes);
		System.out.printf("Espaço de %d MB liberados em %s\n", mbytes, nomeLaboratorio);
	}
	
	public boolean atingiuCota(String nomeLaboratorio) {
		int indice = indiceLaboratorio(nomeLaboratorio);
		return this.contasLaboratorio.get(indice).atingiuCota();
	}
	
	public String laboratorioToString(String nomeLaboratorio) {
		int indice = indiceLaboratorio(nomeLaboratorio);
		return this.contasLaboratorio.get(indice).toString();
	}
	
	public String listaLab() {
		String lista = "";
		for (ContaLaboratorio i : this.contasLaboratorio) {
			lista += i.toString() + "\n";
		}
		return lista;
	}
	
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplinas.add(new Disciplina(nomeDisciplina));
		System.out.printf("Disciplina %s cadastrada com sucesso\n", nomeDisciplina);
	}
	
	public void cadastraDisciplina(String nomeDisciplina, int numNotas) {
		this.disciplinas.add(new Disciplina(nomeDisciplina, numNotas));
		System.out.printf("Disciplina %s com %d notas cadastrada com sucesso\n", nomeDisciplina);
	}
	
	public void cadastraDisciplina(String nomeDisciplina, int numNotas, int[] pesos) {
		this.disciplinas.add(new Disciplina(nomeDisciplina));
		System.out.printf("Disciplina %s com %d notas cadastrada com sucesso\n", nomeDisciplina);
	}
	
	public void cadastraHoras(String nomeDisciplina, int horas) {
		int indice = indiceDisciplina(nomeDisciplina);
		this.disciplinas.get(indice).cadastraHoras(horas);
		System.out.printf("%d horas cadastradas na disciplina %s\n", horas, nomeDisciplina);
	}
	
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		int indice = indiceDisciplina(nomeDisciplina);
		this.disciplinas.get(indice).cadastraNota(nota, valorNota);
		System.out.printf("Nota %d de valor %f na disciplina %s\n", nota, valorNota, nomeDisciplina);
	}
	
	public boolean aprovado(String nomeDisciplina) {
		int indice = indiceDisciplina(nomeDisciplina);
		return this.disciplinas.get(indice).aprovado();
	}
	
	public String disciplinaToString(String nomeDisciplina) {
		int indice = indiceDisciplina(nomeDisciplina);
		return this.disciplinas.get(indice).toString();
	}
	
	public void cadastraCantina(String nomeCantina) {
		this.contasCantina.add(new ContaCantina(nomeCantina));
		System.out.printf("Cantina %s cadastrada com sucesso\n", nomeCantina);
	}
	
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		int indice = indiceCantina(nomeCantina);
		this.contasCantina.get(indice).cadastraLanche(qtdItens, valorCentavos);
		System.out.printf("%d lanches de valor %d na cantina %s\n", qtdItens, valorCentavos, nomeCantina);
	}
	
	public void pagarConta(String nomeCantina, int valorCentavos) {
		int indice = indiceCantina(nomeCantina);
		this.contasCantina.get(indice).pagaConta(valorCentavos);
		System.out.printf("%d pagos na cantina %s\n", valorCentavos, nomeCantina);
	}
	
	public String cantinaToString(String nomeCantina) {
		int indice = indiceCantina(nomeCantina);
		return this.contasCantina.get(indice).toString();
	}
	
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
		System.out.printf("Sua saúde mental está %s!", valor);
	}
	
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
		System.out.printf("Sua saúde física está %s!", valor);
	}
	
	public String geral() {
		return this.saude.geral();
	}
}
 