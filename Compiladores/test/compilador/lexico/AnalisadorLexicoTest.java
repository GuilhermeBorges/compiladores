package compilador.lexico;

import java.io.File;

import compilador.util.token.IToken;
import compilador.util.token.PalavraReservadaToken;
import static compilador.util.token.IToken.Types;

import junit.framework.TestCase;

public class AnalisadorLexicoTest extends TestCase {

	private AnalisadorLexico analisador;

	@Override
	protected void setUp() throws Exception {
		analisador = new AnalisadorLexico(new File("util"+File.separator+"lexico"+File.separator+"source1.txt"));
	}

	public void test1() {
		IToken token = analisador.getNextToken();
		assertEquals("for", token.getCaracteres());
		assertEquals(Types.PALAVRA_RESERVADA, token.getType());
		assertEquals(1, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("da", token.getCaracteres());
		assertEquals(Types.IDENTIFICADOR, token.getType());
		assertEquals(2, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("palavra1", token.getCaracteres());
		assertEquals(Types.IDENTIFICADOR, token.getType());
		assertEquals(3, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("palavra2", token.getCaracteres());
		assertEquals(Types.IDENTIFICADOR, token.getType());
		assertEquals(3, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("step", token.getCaracteres());
		assertEquals(Types.PALAVRA_RESERVADA, token.getType());
		assertEquals(3, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("endif", token.getCaracteres());
		assertEquals(Types.PALAVRA_RESERVADA, token.getType());
		assertEquals(4, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("if", token.getCaracteres());
		assertEquals(Types.PALAVRA_RESERVADA, token.getType());
		assertEquals(5, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("If", token.getCaracteres());
		assertEquals(Types.IDENTIFICADOR, token.getType());
		assertEquals(6, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("123", token.getCaracteres());
		assertEquals(Types.NUMERO, token.getType());
		assertEquals(7, token.getLinha());
		token = analisador.getNextToken();
		assertEquals("234", token.getCaracteres());
		assertEquals(Types.NUMERO, token.getType());
		assertEquals(7, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("3", token.getCaracteres());
		assertEquals(Types.NUMERO, token.getType());
		assertEquals(8, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("4", token.getCaracteres());
		assertEquals(Types.NUMERO, token.getType());
		assertEquals(9, token.getLinha());
		assertTrue(token.isCorrect());
		
		token = analisador.getNextToken();
		assertEquals("5a", token.getCaracteres());
		assertEquals(Types.NUMERO, token.getType());
		assertEquals(10, token.getLinha());
		assertFalse(token.isCorrect());
		
//		token = analisador.getNextToken();
//		assertNull(token);
		
	}
	
}
