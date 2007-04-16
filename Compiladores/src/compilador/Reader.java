package compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Vinícius Ferraz Campos
 *
 */
public class Reader {

	private static int NEWLINE = 10;

	//vide Character
	public static int EOF = 65535;

	BufferedReader reader;

	public Reader(String filePath) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(filePath));
	}


	public char getNext() {
		int caracter;
		do{
			try {
				caracter = reader.read();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
		}while(caracter == NEWLINE);
		return (char) caracter;

	}

	public static void main(String[] args) throws IOException {

		Reader reader  = new Reader("/home/vinicius/scanner.txt");

		for (int i = 0; i < 20; i++) {
			char x = reader.getNext();
			if(x != EOF) {
				System.out.println(x);
			}else  {
				System.out.println("ssssssss");
			}

		}

	}
}
