package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class LiteralToken extends DefaultToken{

	public LiteralToken(String caracteres, int linha, boolean isCorrect) {
		super(IToken.Types.CADEIA_CARACTERES, caracteres, linha, isCorrect);
	}

}
