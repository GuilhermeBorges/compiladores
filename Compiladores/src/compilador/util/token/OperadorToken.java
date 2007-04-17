package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class OperadorToken extends DefaultToken{

	public OperadorToken(String caracteres, int linha) {
		super(IToken.Types.OPERADOR, caracteres, linha, true);
	}

}
