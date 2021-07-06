package dados;

import negocio.Pessoa;
import negocio.RepositorioPessoas;

public class RepositorioPessoasArray implements RepositorioPessoas{
	private int tamanho;
	private Pessoa[] Pessoas;
	private int indice = 0;
	
	public RepositorioPessoasArray(int tamanho) {
	
		this.tamanho = tamanho;
		this.Pessoas = new Pessoa[tamanho];
	}
	
	public void aumentaCapacidade() {
		Pessoa[] PessoasNovo = new Pessoa[tamanho*2];

			 for (int i = 0; i<Pessoas.length; i++) {
				 PessoasNovo[i] = Pessoas[i];
			 }
			Pessoas = PessoasNovo;
			tamanho = Pessoas.length;
		}
	
	
	public void inserirPessoa(Pessoa a) {
		
		if (Pessoas[Pessoas.length - 1] != null) {
			aumentaCapacidade();
		}
		
		Pessoas[indice] = a;
		this.indice++;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < indice; i++) {
			s = s + Pessoas[i] + "\n";
		}
		return s;
	}
	
	public Pessoa procurarPessoa(String numCPF) {
		Pessoa alun = null;
		for(int i = 0; i < indice; i++) {
			if (Pessoas[i].getCpf().equals(numCPF)) {
				alun = Pessoas[i];
			}
		}
		return alun;
	}
	
	public void removerPessoa(String numCPF) {
		
		
		for (int i = 0; i < Pessoas.length; i++) {
			if (Pessoas[i].getCpf().equals(numCPF)) {
				if(i == Pessoas.length - 1) {
					Pessoas[i] = null;
					
				} else {
				transfereElementos(i);
				}
			indice--;
			return;
			}
		}
	}
	
	public void transfereElementos(int indice) {
		for(int i = indice; i<Pessoas.length - 1; i++ ) {
			Pessoas[i] = Pessoas[i+1];
		}
		Pessoas[Pessoas.length - 2 ] = Pessoas[Pessoas.length-1];
		Pessoas[Pessoas.length - 1 ] = null;
	}

	public int getIndice() {
		return indice;
	}
}
