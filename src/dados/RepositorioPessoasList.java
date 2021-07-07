package dados;

import java.util.ArrayList;
import java.util.List;
import negocio.RepositorioPessoas;
import negocio.Pessoa;

public class RepositorioPessoasList implements RepositorioPessoas{
	private List<Pessoa> Pessoas = new ArrayList<>();
	

	public void inserirPessoa(Pessoa Pessoa) throws CadastroRepetidoException {
		for(Pessoa pessoa: Pessoas) {
			if(pessoa.getCpf().equals(Pessoa.getCpf())) {
				throw new CadastroRepetidoException();
			}
		}
		Pessoas.add(Pessoa);
	}
	
	public Pessoa procurarPessoa(String numCPF) throws UsuarioNaoEncontradoException {
		Pessoa a = null;
		for(Pessoa al : Pessoas) {
			if(al.getCpf().equals(numCPF)) {
				 a = al;
			} 
			
		}
			if(a == null) {
				throw new UsuarioNaoEncontradoException();
			}
		return a;
		
	}
	
	public void removerPessoa(String numCPF) {
		Pessoa a = null;
		for (Pessoa al : Pessoas) {
			if(al.getCpf().equals(numCPF)) {
				a = al;
			}
		}
		Pessoas.remove(a);
	}
	public void listarPessoas() {
		for (Pessoa Pessoa : Pessoas) {
			System.out.println(Pessoa);
		}
	}
}
