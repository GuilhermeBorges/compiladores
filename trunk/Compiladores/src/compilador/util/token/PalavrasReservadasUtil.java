package compilador.util.token;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vinicius F. Campos
 *
 */
public class PalavrasReservadasUtil {

	private Set<String> palavrasReservadas ;

	/**
	 * 
	 */
	public PalavrasReservadasUtil() {
		init();
		
	}

	/**
	 * 
	 */
	private void init() {
		palavrasReservadas = new HashSet<String>();
		palavrasReservadas.add("var");
		palavrasReservadas.add("integer");
		palavrasReservadas.add("if");
		palavrasReservadas.add("then");
		palavrasReservadas.add("else");
		palavrasReservadas.add("endif");
		palavrasReservadas.add("for");
		palavrasReservadas.add("to");
		palavrasReservadas.add("step");
		palavrasReservadas.add("do");
		palavrasReservadas.add("endfor");
		palavrasReservadas.add("read");
		palavrasReservadas.add("write");
		palavrasReservadas.add("writeln");
		
	}
	
	
	/**
	 * @param palavra
	 * @return
	 */
	public boolean isPalavraReservada(String palavra) {
		return palavrasReservadas.contains(palavra);
	}
}
