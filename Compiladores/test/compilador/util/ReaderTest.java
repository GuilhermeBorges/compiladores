package compilador.util;

import java.io.File;

import junit.framework.TestCase;

public class ReaderTest extends TestCase {

	private Reader reader1;
	private Reader reader2;

	@Override
	protected void setUp() throws Exception {
		reader1 = new Reader(new File("util/reader/source1.txt"));
		reader2 = new Reader(new File("util/reader/source2.txt"));
	}

	public void test1() {
		assertEquals('1', reader1.getNextChar());
		assertEquals(' ', reader1.getNextChar());
		assertEquals('2', reader1.getNextChar());
		assertEquals(' ', reader1.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader1.getNextChar());
		assertEquals('3', reader1.getNextChar());
		assertEquals(' ', reader1.getNextChar());
		assertEquals('4', reader1.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader1.getNextChar());
		assertEquals('5', reader1.getNextChar());
		assertEquals(' ', reader1.getNextChar());
		assertEquals(' ', reader1.getNextChar());
		assertEquals('6', reader1.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader1.getNextChar());
		assertEquals(' ', reader1.getNextChar());
		assertEquals('7', reader1.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader1.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader1.getNextChar());
		assertEquals('8', reader1.getNextChar());
		assertEquals('9', reader1.getNextChar());
		assertEquals(reader1.EOF, reader1.getNextChar());
		assertEquals(reader1.EOF, reader1.getNextChar());
	}
	
	public void test2() {
		assertEquals('f', reader2.getNextChar());
		assertEquals('o', reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals('d', reader2.getNextChar());
		assertEquals('a', reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals(' ', reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals('n', reader2.getNextChar());
		assertEquals('e', reader2.getNextChar());
		assertEquals('h', reader2.getNextChar());
		assertEquals(' ', reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals('n', reader2.getNextChar());
		assertEquals('a', reader2.getNextChar());
		assertEquals('o', reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals('?', reader2.getNextChar());
		assertEquals(Character.LINE_SEPARATOR, reader2.getNextChar());
		assertEquals(reader1.EOF, reader2.getNextChar());
		
	}
}
