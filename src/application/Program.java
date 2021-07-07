package application;

import java.util.Scanner;

import dados.CadastroRepetidoException;
import dados.RepositorioPessoasArray;
import dados.RepositorioPessoasList;
import dados.UsuarioNaoEncontradoException;
import negocio.Aluno;
import negocio.Curso;
import negocio.Professor;

public class Program {
	private static RepositorioPessoasArray array = new RepositorioPessoasArray(5);
	private static RepositorioPessoasList list = new RepositorioPessoasList();
	public static void main(String[] args) {
		
		
		Curso c = new Curso(1, "Programação");
		Aluno joao = new Aluno("João", "123.456", 16, c);
		Aluno jose = new Aluno("José", "234.567", 16, c);
		try {
			array.inserirPessoa(joao);
			list.inserirPessoa(joao);
			array.inserirPessoa(jose);
			list.inserirPessoa(jose);
		}catch(CadastroRepetidoException l) {
			System.out.println(l.getMessage());
		}
		
		/*Aluno jose = new Aluno("José", "234.567", 16, c);
		Aluno maria = new Aluno("Maria", "258.369", 30, c);
		Aluno camila = new Aluno("Camila", "147.963", 25, c);		
		Professor juliana = new Professor("Juliana", "147.963", 25, 1100.0);
		
		Pessoa p = new Pessoa("Pessoal", "147.963", 25);
		
		
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
		pessoas.toString();
		
		
		System.out.println("==============================================");
		
		pessoas.remover("123.456");
		pessoas.toString();*/
		
		Scanner input = new Scanner(System.in);
		int opcao;
		do{
			System.out.println("\n");
			System.out.println("+--------------------------------------+");
			System.out.println("|                 MENU                 |");
			System.out.println("+--------------------------------------+");
			System.out.println(
				"| 01 - Adicionar                                      |\n" +
				"| 02 - Procurar                                       |\n" +
				"| 03 - Remover                                        |\n" +
				"| 04 - Exibir todos                                   |\n" +
				"| 05 - Sair                                           |\n"                             
				);
			System.out.println("+--------------------------------------+\n\n");
			opcao = input.nextInt();
			switch(opcao) {
			case 1:
				adicionar(c);
				break;
			case 2:
				procurar();
				break;
			case 3:
				remover();
				break;
			case 4:
				System.out.println(array.toString());
				list.listarPessoas();
				break;
			default:
				break;
			}
		}while(opcao!=5);
		System.out.println("Adeus!");
		input.close();
	}

	public static void adicionar(Curso curso) {
		Scanner input = new Scanner(System.in);
		int opcao;
		String nome, cpf;
		int idade;
		double salario;
		do{
			System.out.println("\n");
			System.out.println("+--------------------------------------+");
			System.out.println("|                 MENU                 |");
			System.out.println("+--------------------------------------+");
			System.out.println(
				"| 01 - Aluno                                          |\n" +
				"| 02 - Professor                                      |\n" +
				"| 03 - Sair                                           |\n"                             
				);
			System.out.println("+--------------------------------------+\n\n");
			opcao = input.nextInt();
			switch(opcao) {
			case 1:
				System.out.print("Insira o nome do aluno: ");
				nome = input.next();
				System.out.print("Insira o CPF do aluno: ");
				cpf = input.next();
				System.out.print("Insira a idade do aluno: ");
				idade = input.nextInt();
				Aluno A = new Aluno(nome, cpf, idade, curso);
				/*System.out.print(A.toString());*/
				try {
					array.inserirPessoa(A);
					list.inserirPessoa(A);
				}catch(CadastroRepetidoException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 2:
				System.out.print("\nInsira o nome do professor: ");
				nome = input.next();
				System.out.print("\nInsira o CPF do professor: ");
				cpf = input.next();
				System.out.println("\nInsira a idade do professor: ");
				idade = input.nextInt();
				System.out.println("\nInsira a salario do professor: ");
				salario = input.nextDouble();
				Professor P = new Professor(nome, cpf, idade, salario);
				try {
					array.inserirPessoa(P);
					list.inserirPessoa(P);
				}catch(CadastroRepetidoException c) {
					System.out.println(c.getMessage());
				}
				break;
			default:
				break;
			}
		}while(opcao!=3);	
		input.close();
	}

	public static void procurar() {
		Scanner input = new Scanner(System.in);
		String cpf;
		System.out.println("Digite o cpf: ");
		cpf = input.next();
		try {
			System.out.println(array.procurarPessoa(cpf));
			System.out.println(list.procurarPessoa(cpf));
		}catch( UsuarioNaoEncontradoException c) {
			System.out.println(c.getMessage());
		}
		input.close();
		
	}
	
	public static void remover() {
		Scanner input = new Scanner(System.in);
		String cpf;
		System.out.println("Digite o cpf: ");
		cpf = input.next();
		array.removerPessoa(cpf);
		list.removerPessoa(cpf);
		System.out.println(array.toString());
		list.listarPessoas();
		input.close();
	}
	
	
}