package entities;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAlunosArray {
	private List<Aluno> alunos = new ArrayList<>();
	

	public void inserirAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public Aluno procurarAluno(String numCPF) {
		Aluno a = null;
		for(Aluno al : alunos) {
			if(al.getCpf().equals(numCPF)) {
				 a = al;
			} 
			
		}
		return a;
		
	}
	
	public void removerAluno(String numCPF) {
		Aluno a = null;
		for (Aluno al : alunos) {
			if(al.getCpf().equals(numCPF)) {
				a = al;
			}
		}
		alunos.remove(a);
	}
	public void exibeLista() {
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
	}
}
