package dados;

import negocio.Aluno;

public class RepositorioAlunosArray{
	private int tamanho;
	private Aluno[] Alunos;
	private int indice = 0;
	
	public RepositorioAlunosArray(int tamanho) {
	
		this.tamanho = tamanho;
		this.Alunos = new Aluno[tamanho];
	}
	
	public void aumentaCapacidade() {
		Aluno[] AlunosNovo = new Aluno[tamanho*2];

			 for (int i = 0; i<Alunos.length; i++) {
				 AlunosNovo[i] = Alunos[i];
			 }
			Alunos = AlunosNovo;
			tamanho = Alunos.length;
		}
	
	
	public void inserir(Aluno a) {
		
		if (Alunos[Alunos.length - 1] != null) {
			aumentaCapacidade();
		}
		
		Alunos[indice] = a;
		this.indice++;
	}
	
	public void exibir() {
		for(int i = 0; i < indice; i++) {
			System.out.println(Alunos[i]);
		}
	}
	
	public Aluno procurar(String numCPF) {
		Aluno alun = null;
		for(int i = 0; i < indice; i++) {
			if (Alunos[i].getCpf().equals(numCPF)) {
				alun = Alunos[i];
			}
		}
		return alun;
	}
	
	public void remover(String numCPF) {
		
		
		for (int i = 0; i < Alunos.length; i++) {
			if (Alunos[i].getCpf().equals(numCPF)) {
				if(i == Alunos.length - 1) {
					Alunos[i] = null;
					
				} else {
				transfereElementos(i);
				}
			indice--;
			return;
			}
		}
	}
	
	public void transfereElementos(int indice) {
		for(int i = indice; i<Alunos.length - 1; i++ ) {
			Alunos[i] = Alunos[i+1];
		}
		Alunos[Alunos.length - 2 ] = Alunos[Alunos.length-1];
		Alunos[Alunos.length - 1 ] = null;
	}

	public int getIndice() {
		return indice;
	}
}
