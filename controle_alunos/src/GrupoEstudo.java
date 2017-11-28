import java.util.ArrayList;

public class GrupoEstudo {
	
	private String tema;
	
	public GrupoEstudo(String tema) {
		this.tema = tema;
	}
	
	public String toString() {
		return this.tema;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		GrupoEstudo ge = (GrupoEstudo) obj;
		if (!this.tema.equals(ge.tema))
			return false;
		
		return true;
	}
	
	public int hashCode() {
		return this.tema.hashCode();
	}
}
