package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.List;
import java.util.Scanner;

import dados.CadastroRepetidoException;
import dados.RepositorioPessoasArray;
import dados.RepositorioPessoasList;
import dados.UsuarioNaoEncontradoException;
import dados.PessoasDao;
import negocio.Aluno;
import negocio.Curso;
//import negocio.Pessoa;
import negocio.Professor;



public class Program {
	private static RepositorioPessoasArray array = new RepositorioPessoasArray(5);
	private static RepositorioPessoasList list = new RepositorioPessoasList();
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Curso c = new Curso(1, "Programação");

		Aluno joao = new Aluno("João", "123.456", 16, c);
		Aluno jose = new Aluno("José", "234.567", 16, c);
		//Professor Jarles = new Professor("Joyce","637.483",23,1042);
		//Pessoa Jonas = new Pessoa("Firmino","725.653",23);
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
		// BOTEI O COMENTARIO APARTIR DAQUI
		//Scanner input = new Scanner(System.in);
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
		int opcao;
		String nome, cpf;
		int idade;
		double salario;
			System.out.println("\n");
			System.out.println("+--------------------------------------+");
			System.out.println("|                 MENU                 |");
			System.out.println("+--------------------------------------+");
			System.out.println(
				"| 01 - Aluno                                          |\n" +
				"| 02 - Professor                                      |\n"                             
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
				System.out.print("Insira o curso do aluno");
				PessoasDao ad = new PessoasDao();
				Aluno A = new Aluno(nome, cpf, idade, curso);
				/*System.out.print(A.toString());*/
		try {
					array.inserirPessoa(A);
					list.inserirPessoa(A);
					ad.adicionaAluno(A);
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
				PessoasDao pd = new PessoasDao();
				Professor P = new Professor(nome, cpf, idade, salario);
				try {
					array.inserirPessoa(P);
					list.inserirPessoa(P);
					pd.adicionaProf(P);
				}catch(CadastroRepetidoException c) {
					System.out.println(c.getMessage());
				}
				break;
			default:
				break;
			}
	}

	public static void procurar() {
		String cpf;
		System.out.println("Digite o cpf: ");
		cpf = input.next();
		try {
			System.out.println(array.procurarPessoa(cpf));
			System.out.println(list.procurarPessoa(cpf));
		}catch( UsuarioNaoEncontradoException c) {
			System.out.println(c.getMessage());
		}	
	}
	
	public static void remover() {
		PessoasDao pd = new PessoasDao();
	
		String cpf;
		int opcao;
			System.out.println("\n");
			System.out.println("+--------------------------------------+");
			System.out.println("|                 MENU                 |");
			System.out.println("+--------------------------------------+");
			System.out.println(
				"| 01 - Aluno                                          |\n" +
				"| 02 - Professor                                      |\n"                             
				);
			System.out.println("+--------------------------------------+\n\n");
			opcao = input.nextInt();
			System.out.println("Digite o cpf: ");
			cpf = input.next();
			if (opcao == 1) {
				pd.removeAluno(cpf);
			}
			else if (opcao == 2) {
				pd.removeProf(cpf);
			}	
		array.removerPessoa(cpf);
		list.removerPessoa(cpf);
		System.out.println(array.toString());
		list.listarPessoas();
	}
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
			
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/pessoas", "root", "");
			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
	
