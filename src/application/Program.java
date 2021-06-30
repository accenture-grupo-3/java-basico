package application;

import entities.Aluno;
import entities.Curso;
import entities.Professor;
import entities.Pessoa;
import entities.RepositorioPessoasArray;

public class Program {

	public static void main(String[] args) {
		
		
		Curso c = new Curso(1, "Programação");
		Aluno a = new Aluno("João", "123.456", 16, c);
		Aluno b = new Aluno("josé", "234.567", 16, c);
		Aluno aa = new Aluno("Kelly", "258.369", 30, c);
		Aluno aaa = new Aluno("Camila", "147.963", 25, c);
		
		Professor juliana = new Professor("Juliana", "147.963", 25, 1100.0);
		
		Pessoa p = new Pessoa("Pessoa", "147.963", 25);
		
		//System.out.println(p);
		
		
		RepositorioPessoasArray arr = new RepositorioPessoasArray();
		
		arr.inserirPessoa(a);
		arr.inserirPessoa(juliana);
		arr.inserirPessoa(p);
		
		
		arr.exibeLista();
		
		
		
		
		
		
		/*RepositorioAlunosArray arr = new RepositorioAlunosArray();
		
		arr.inserirAluno(a);
		arr.inserirAluno(b);
		System.out.println(arr.procurarAluno("123.456"));
		arr.exibeLista();
		arr.removerAluno("123.456");
		arr.exibeLista();*/
		
		
	
	}

}
