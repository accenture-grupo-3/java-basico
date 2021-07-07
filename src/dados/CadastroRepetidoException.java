package dados;

public class CadastroRepetidoException extends Exception {
	
	public CadastroRepetidoException() {
		super("\nCadastro já encontrado ");
	}

}
