package dados;

public class UsuarioNaoEncontradoException extends Exception{
	
	public  UsuarioNaoEncontradoException() {
		super("\nUsu�rio n�o encontrado!");
	}
}
