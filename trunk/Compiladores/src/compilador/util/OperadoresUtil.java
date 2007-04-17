package compilador.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vinicius F. Campos
 *
 */
public class OperadoresUtil {

	private Set<Character> operadores ;

	/**
	 * 
	 */
	public OperadoresUtil() {
		init();
		
	}

	/**
	 * FIXME: Definir exatamente quem serão os operadores, só estes? ou "<" ">" "<=" "!="...
	 */
	private void init() {
		operadores = new HashSet<Character>();
		operadores.add('+');
		operadores.add('-');
		operadores.add('*');
		operadores.add('/');
		operadores.add('=');
		
	}
	
	
	/**
	 * @param palavra
	 * @return
	 */
	public boolean isOperador(Character palavra) {
		return operadores.contains(palavra);
	}
}
