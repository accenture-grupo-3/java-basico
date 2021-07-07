package dados;

public class UsuarioNaoEncontradoException extends Exception{
	
	public  UsuarioNaoEncontradoException() {
		super("\nUsuário não encontrado!");
	}
}
