package compilador.util.token;


/**
 * @author Vinicius F. Campos
 *
 */
public class DefaultToken implements IToken {

	protected Types tipo;
	
	protected String caracteres;
	
	protected int linha;

	private boolean isCorrect;

	/**
	 * @param tipo 
	 * @param caracteres
	 * @param linha
	 */
	public DefaultToken(Types tipo, String caracteres, int linha, boolean isCorrect) {
		this.tipo = tipo;
		this.caracteres = caracteres;
		this.linha = linha;
		this.isCorrect = isCorrect;
	}
	
	/* (non-Javadoc)
	 * @see compilador.util.IToken#getCaracteres()
	 */
	public String getCaracteres() {
		return caracteres;
	}
	
	/* (non-Javadoc)
	 * @see compilador.util.IToken#getLinha()
	 */
	public int getLinha() {
		return linha;
	}
	
	/* (non-Javadoc)
	 * @see compilador.util.IToken#getType()
	 */
	public Types getType() {
		return tipo;
	}

	@Override
	public String toString() {
		return this.caracteres+", linha: "+this.linha;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

}
