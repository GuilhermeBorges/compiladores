package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class IdentificadorToken extends DefaultToken{

	public IdentificadorToken(String caracteres, int linha) {
		super(IToken.Types.IDENTIFICADOR, caracteres, linha, true);
	}

}
