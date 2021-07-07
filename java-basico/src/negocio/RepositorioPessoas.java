package negocio;

import dados.CadastroRepetido;
import dados.UsuarioNaoEncontradoException;

public interface RepositorioPessoas {
	void inserirPessoa (Pessoa pessoa) throws CadastroRepetido;
	Pessoa procurarPessoa(String numCpf) throws UsuarioNaoEncontradoException;
	void removerPessoa(String numCpf) throws UsuarioNaoEncontradoException;
}
