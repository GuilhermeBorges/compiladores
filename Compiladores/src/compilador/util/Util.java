package compilador.util;

/**
 * @author Vinicius F. Campos
 *
 */
public class Util {

	/**
	 * @param string
	 * @return
	 */
	public static boolean isInteiroValido(String string) {
		try{
			new Integer(string);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
