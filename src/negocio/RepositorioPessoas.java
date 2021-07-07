package negocio;

import dados.CadastroRepetidoException;
import dados.UsuarioNaoEncontradoException;

public interface RepositorioPessoas {
	void inserirPessoa(Pessoa pessoa) throws CadastroRepetidoException;
	Pessoa procurarPessoa(String numCpf) throws UsuarioNaoEncontradoException;
	void removerPessoa(String numCpf);
}
