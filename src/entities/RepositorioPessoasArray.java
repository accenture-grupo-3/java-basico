package entities;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoasArray {
	private List<Pessoa> Pessoas = new ArrayList<>();
	

	public void inserirPessoa(Pessoa Pessoa) {
		Pessoas.add(Pessoa);
	}
	
	public Pessoa procurarPessoa(String numCPF) {
		Pessoa a = null;
		for(Pessoa al : Pessoas) {
			if(al.getCpf().equals(numCPF)) {
				 a = al;
			} 
			
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
	public void exibeLista() {
		for (Pessoa Pessoa : Pessoas) {
			System.out.println(Pessoa);
		}
	}
}
