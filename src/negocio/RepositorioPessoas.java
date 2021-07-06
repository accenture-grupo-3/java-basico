package negocio;

public interface RepositorioPessoas {
	void inserirPessoa(Pessoa pessoa);
	Pessoa procurarPessoa(String numCpf);
	void removerPessoa(String numCpf);
}
