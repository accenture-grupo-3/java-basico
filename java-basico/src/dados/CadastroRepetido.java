package dados;

public class CadastroRepetido extends Exception {
	
	public  CadastroRepetido() {
		super("\nCadastro já encontrado ");
	}
}
