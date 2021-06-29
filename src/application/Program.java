package application;

import entities.Aluno;
import entities.Curso;
//import entities.RepositorioAlunosArray;

public class Program {

	public static void main(String[] args) {
		
		
		Curso c = new Curso(1, "Programação");
		Aluno a = new Aluno("João", "123.456", 16, c);
		Aluno b = new Aluno("josé", "234.567", 16, c);
		Aluno aa = new Aluno("Kelly", "258.369", 30, c);
		Aluno aaa = new Aluno("Camila", "147.963", 25, c);
		ArraysAlunos arr = new ArraysAlunos(3);
		
		arr.inserir(aaa);
		arr.inserir(aa);
		arr.inserir(a);
		arr.inserir(b);
		arr.exibir();
		System.out.println(arr.procurar("147.963"));
		arr.remover("123.456");
		arr.exibir();
		
		
		
		
		
		
		/*RepositorioAlunosArray arr = new RepositorioAlunosArray();
		
		arr.inserirAluno(a);
		arr.inserirAluno(b);
		System.out.println(arr.procurarAluno("123.456"));
		arr.exibeLista();
		arr.removerAluno("123.456");
		arr.exibeLista();*/
	
	}

}
