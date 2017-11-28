import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class ControleAlunos {
	private HashSet<Aluno> alunos;
	private HashMap<String, ArrayList<Aluno>> grupo;
	private ArrayList<Aluno> respondedores;
	
	public void cadastraAluno(String nome, String matricula, String curso) {
		this.alunos.add(new Aluno(nome, matricula, curso));
	}
	
	private Aluno buscaAluno(String matricula) {
		for (Aluno aln : this.alunos) {
			if (aln.getMatricula().equals(matricula)) {
				return aln;
			}
		}
		throw new IllegalArgumentException("Aluno não cadastrado");
	}
	
	public String consultaAluno(String matricula) {
		try {
			return buscaAluno(matricula).toString();
		} catch(IllegalArgumentException iae) {
			throw iae;
		}
	}
	
	public void cadastraGrupo(String nome) {
		this.grupo.put(nome, new ArrayList<Aluno>());
	}
	
	public void alocarAluno(String matricula, String nome) {
		try {
			this.grupo.get(nome).add(buscaAluno(matricula));
		} catch(IllegalArgumentException iae) {
			throw iae;
		}
	}
	
	public String listaGrupo(String nomeGrupo) {
		String lista = "";
		for (Aluno aln : this.grupo.get(nomeGrupo)) {
			lista += "* " + aln.toString() + System.lineSeparator();
		}
		return lista;
	}
	
	public void cadastraRespondedor(String matricula) {
		try {
			this.respondedores.add(buscaAluno(matricula));
		} catch(IllegalArgumentException iae) {
			throw iae;
		}
	}
	
	public String listaRespondedores() {
		String lista = "";
		for (int i=0; i < this.respondedores.size(); i++) {
			lista += (i + 1) + ". " + this.respondedores.get(i).toString() + System.lineSeparator();
		}
		return lista;
	}
	
}
