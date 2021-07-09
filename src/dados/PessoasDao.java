package dados;

import java.sql.*;
import java.util.*;

import negocio.Aluno;
import negocio.Curso;
import negocio.Pessoa;
import negocio.Professor;

public class PessoasDao {
	private Connection con = null;
	private Curso curso;

	public PessoasDao() {
		this.con = new ConexaoFactory().getConnection();
	}

	public void AdicionaPessoa(Pessoa tbpessoa) {

		String sql = "INSERT INTO  tbpessoa(nome,cpf,idade) VALUES(?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tbpessoa.getNome());
			stmt.setString(2, tbpessoa.getCpf());
			stmt.setInt(3, tbpessoa.getIdade());
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionaProf(Professor tbprofessor) {

		String sql = "INSERT INTO  tbprofessor(nome,cpf,idade,salario) VALUES(?,?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, tbprofessor.getNome());
			stmt.setString(2, tbprofessor.getCpf());
			stmt.setInt(3, tbprofessor.getIdade());
			stmt.setDouble(4, tbprofessor.getSalario());
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeProf(String cpf) {

		String sql = "DELETE FROM  tbprofessor where cpf = ? ";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();

			System.out.println("Professor com CPF " + cpf + " Deletado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeAluno(String cpf) {

		String sql = "DELETE FROM  tbalunos where cpf = ? ";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();

			System.out.println("Aluno com CPF " + cpf + " Deletado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void procurarProfessor(String cpf) {

		PreparedStatement stmt = null;

		try {
			String sql = "SELECT * from tbprofessor WHERE cpf = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String Cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				double salario = rs.getDouble("salario");

				System.out.println("Cpf:- " + Cpf + " Nome:- " + nome + " Idade:- " + idade + " Salario:- " + salario);

			}

			System.out.println("Professor com CPF " + cpf + " Procurado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void procurarAluno(String cpf) {

		PreparedStatement stmt = null;

		try {
			String sql = "SELECT * from tbalunos WHERE cpf = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String Cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String curso = rs.getString("curso");

				System.out.println("Cpf:- " + Cpf + " Nome:- " + nome + " Idade:- " + idade + " Curso:- " + curso);

			}

			System.out.println("Professor com CPF " + cpf + " Procurado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void ExibirTodosAlunos() {

		String sql = "SELECT * FROM  tbalunos";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String Cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String curso = rs.getString("curso");
				System.out.println("Aluno com cpf " +  "   " + nome  + "   " + Cpf   + "   " +  idade  + "   " + curso   + "   " + "\nEncontrado!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void exibirTodosProfessores() {
		String sql = "SELECT * FROM  tbprofessor";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String nome = rs.getString("nome");
				String Cpf = rs.getString("cpf");
				int idade = rs.getInt("idade");
				double salario = rs.getDouble("salario");
				System.out.println("Professor com cpf " +  "   " + nome  + "   " + Cpf   + "   " +  idade  + "   " + salario   + "   " + "\nEncontrado!");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionaCurso(Curso tbcurso) {

		String sql = "INSERT INTO  tbcurso(codigo,nomecurso) VALUES(?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, tbcurso.getCodigo());
			stmt.setString(2, tbcurso.getNome());
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionaAluno(Aluno tbalunos) {

		String sql = "INSERT INTO  tbalunos(nome,cpf,idade,curso) VALUES(?,?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, tbalunos.getNome());
			stmt.setString(2, tbalunos.getCpf());
			stmt.setInt(3, tbalunos.getIdade());
			stmt.setString(4, tbalunos.getCurso().getNome());
			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Pessoa> getLista() {

		List<Pessoa> tbpessoa = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM pessoa";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa(rs.getString("nome"), rs.getString("CPF"), rs.getInt(12));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setIdade(rs.getInt(12));
				tbpessoa.add(pessoa);
			}

			rs.close();
			stmt.close();
			return tbpessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Pessoa> getLista2() {

		List<Pessoa> tbProfessor = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM pessoa";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Professor pessoa = new Professor(rs.getString("nome"), rs.getString("CPF"), rs.getInt(12),
						rs.getDouble(0));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setIdade(rs.getInt(12));
				pessoa.setSalario(rs.getDouble(0));
				tbProfessor.add(pessoa);
			}

			rs.close();
			stmt.close();
			return tbProfessor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Pessoa> getLista3() {

		List<Pessoa> tbAlunos = new ArrayList<Pessoa>();
		List<Curso> tbCurso = new ArrayList<Curso>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT aluno.nome, aluno.cpf ,  aluno.idade, Curso.nome FROM Curso JOIN Aluno ON Aluno.curso = Curso.nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno pessoa = new Aluno();
				Curso curso = new Curso();
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setIdade(rs.getInt(12));
				curso.setNome(rs.getString("Algoritmo"));
				curso.setCodigo(rs.getInt(2));
				tbAlunos.add(pessoa);
				tbCurso.add(curso);
			}

			rs.close();
			stmt.close();
			return tbAlunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
