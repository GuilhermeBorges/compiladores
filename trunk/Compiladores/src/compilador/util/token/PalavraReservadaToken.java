package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class PalavraReservadaToken extends DefaultToken{

	public PalavraReservadaToken(String caracteres, int linha) {
		super(IToken.Types.PALAVRA_RESERVADA, caracteres, linha, true);
	}

}
