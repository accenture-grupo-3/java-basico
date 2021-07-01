package application;

import entities.Aluno;
import entities.Curso;
import entities.Professor;
import estruturaDeDados.RepositorioAlunosArray;
import estruturaDeDados.RepositorioPessoasArray;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		
		Curso c = new Curso(1, "Programação");
		Aluno joao = new Aluno("João", "123.456", 16, c);
		Aluno jose = new Aluno("José", "234.567", 16, c);
		Aluno maria = new Aluno("Maria", "258.369", 30, c);
		Aluno camila = new Aluno("Camila", "147.963", 25, c);		
		Professor juliana = new Professor("Juliana", "147.963", 25, 1100.0);
		
		Pessoa p = new Pessoa("Pessoa", "147.963", 25);
		
		
		//cria lista de alunos
		RepositorioAlunosArray alunos = new RepositorioAlunosArray(3);
		

		alunos.inserir(joao);
		alunos.inserir(jose);
		alunos.inserir(maria);
		alunos.inserir(camila);
		alunos.exibir();
		
		System.out.println("==============================================");
		
		System.out.println(alunos.procurar("123.456"));
		
		System.out.println("==============================================");
		
		alunos.remover("123.456");
		alunos.exibir();
		
		
		System.out.println("==============================================");
		
		//criar lista de pessoas
		RepositorioPessoasArray pessoas = new RepositorioPessoasArray(3);
		
		pessoas.inserir(joao);
		pessoas.inserir(juliana);
		pessoas.inserir(p);
		pessoas.exibir();
		
		
		System.out.println("==============================================");
		
		pessoas.remover("123.456");
		pessoas.exibir();
		
		
		
		
		
		
		
				
		
	
	}

}
