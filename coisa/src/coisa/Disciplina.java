package coisa;

public class Disciplina {
	private String nomeDisciplina;
	private int horasTrabalhadas;
	private double media;
	private double[] notas = new double[4];
	private int[] pesos = {1, 1, 1, 1};
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public Disciplina(String nomeDisciplina, int numNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[numNotas];
		this.pesos = new int[numNotas];
		for (int i = 0; i < numNotas; i ++) {
			pesos[i] = 1;
		}
	}
	
	public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[numNotas];
		this.pesos = pesos;
	}
	
	public String getNomeDisciplina() {
		return this.nomeDisciplina;
	}
	
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas = horas;
	}
	
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	public void calculaMedia() {
		int soma = 0;
		for (int i = 0; i < this.pesos.length; i++) {
			soma += this.pesos[i];
		}
		this.media = 0;
		for (int i = 0; i < this.notas.length; i++) {
			this.media += this.notas[i] * this.pesos[i] / soma;
		}
	}
	
	public boolean aprovado() {
		calculaMedia();
		if (this.media >= 7) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String notas = "";
		for (int i = 0; i < this.notas.length; i++) {
			notas += this.notas[i] + ", ";
		}
		return this.nomeDisciplina + " " + this.horasTrabalhadas + " " + 
	    this.media + " [" + notas + "]";
	}
}
