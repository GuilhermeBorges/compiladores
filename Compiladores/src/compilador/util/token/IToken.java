package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public interface IToken {

	public static enum Types {IDENTIFICADOR, NUMERO, CADEIA_CARACTERES, DIGITO, LETRA, OPERADOR, DELIMITADOR, PALAVRA_RESERVADA};
	
	public String getCaracteres();
	
	public int getLinha();
	
	public Types getType();
	
	/**
	 * 
	 * @return true caso o token esteja correto, false caso contrario.
	 * ex: 7b eh um numero incorreto.
	 */
	public boolean isCorrect();
	
}
