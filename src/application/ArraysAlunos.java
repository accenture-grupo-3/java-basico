package application;

import entities.Aluno;

public class ArraysAlunos {
	private int tamanho;
	private Aluno[] alunos;
	private int indice = 0;
	
	public ArraysAlunos(int tamanho) {
	
		this.tamanho = tamanho;
		this.alunos = new Aluno[tamanho];
	}
	
	public void aumentaCapacidade() {
		Aluno[] alunosNovo = new Aluno[tamanho*2];

			 for (int i = 0; i<alunos.length; i++) {
				 alunosNovo[i] = alunos[i];
			 }
			alunos = alunosNovo;
			tamanho = alunos.length;
		}
	
	
	public void inserir(Aluno a) {
		
		if (alunos[alunos.length - 1] != null) {
			aumentaCapacidade();
		}
		
		alunos[indice] = a;
		this.indice++;
	}
	
	public void exibir() {
		for(int i = 0; i < indice; i++) {
			System.out.println(alunos[i]);
		}
	}
	
	public Aluno procurar(String numCPF) {
		Aluno alun = null;
		for(int i = 0; i < indice; i++) {
			if (alunos[i].getCpf().equals(numCPF)) {
				alun = alunos[i];
			}
		}
		return alun;
	}
	
	public void remover(String numCPF) {
		
		
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i].getCpf().equals(numCPF)) {
				if(i == alunos.length) {
					alunos[i] = null;
					
				} else {
				transfereElementos(i);
				}
			indice--;
			return;
			}
		}
	}
	
	public void transfereElementos(int indice) {
		for(int i = indice; i<alunos.length - 1; i++ ) {
			alunos[i] = alunos[i+1];
		}
		alunos[alunos.length - 2 ] = alunos[alunos.length-1];
		alunos[alunos.length - 1 ] = null;
	}

	public int getIndice() {
		return indice;
	}
}
