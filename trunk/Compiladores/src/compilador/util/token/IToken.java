package compilador.util.token;

public interface IToken {

	public static enum Types {IDENTIFICADOR, NUMERO, CADEIA_CARACTERES, DIGITO, LETRA, OPERADOR, DELIMITADOR, PALAVRA_RESERVADA};
	
	public String getCaracteres();
	
	public int getLinha();
	
	public Types getType();
	
}
