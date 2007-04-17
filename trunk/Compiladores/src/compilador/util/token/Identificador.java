package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class Identificador extends DefaultToken{

	public Identificador(String caracteres, int linha) {
		super(IToken.Types.IDENTIFICADOR, caracteres, linha);
	}

}
