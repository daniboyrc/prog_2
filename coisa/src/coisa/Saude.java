package coisa;

public class Saude {
	private String saudeFisica;
	private String saudeMental;
	private String emoji = "";
	
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";		
	}
	
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		this.emoji = "";
	}
	
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		this.emoji = "";
	}
	
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	public String geral() {
		if (this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")) {
			return "boa" + this.emoji;
		}
		else if (this.saudeFisica != this.saudeMental) {
			return "ok" + this.emoji;
		}
		else {
			return "fraca" + this.emoji;
		}
	}
}
