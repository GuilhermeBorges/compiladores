package compilador.util.token;

/**
 * @author Vinicius F. Campos
 *
 */
public class PalavraReservada extends DefaultToken{

	public PalavraReservada(String caracteres, int linha) {
		super(IToken.Types.PALAVRA_RESERVADA, caracteres, linha);
	}

}
