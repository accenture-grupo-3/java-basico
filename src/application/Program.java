package application;

import entities.Aluno;
import entities.Curso;
import entities.RepositorioAlunosArray;

public class Program {

	public static void main(String[] args) {
		Curso c = new Curso(1, "Programação");
		Aluno a = new Aluno("João", "123.456", 16, c);
		Aluno b = new Aluno("josé", "234.567", 16, c);
		RepositorioAlunosArray arr = new RepositorioAlunosArray();
		
		arr.inserirAluno(a);
		arr.inserirAluno(b);
		System.out.println(arr.procurarAluno("123.456"));
		arr.exibeLista();
		arr.removerAluno("123.456");
		arr.exibeLista();
	
	}

}
