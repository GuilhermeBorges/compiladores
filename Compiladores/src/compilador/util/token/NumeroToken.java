package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class NumeroToken extends DefaultToken{

	public NumeroToken(String caracteres, int linha, boolean isCorrect) {
		super(IToken.Types.NUMERO, caracteres, linha, isCorrect);
	}

}
