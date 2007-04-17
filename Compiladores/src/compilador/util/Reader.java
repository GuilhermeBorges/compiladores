package compilador.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Vinícius Ferraz Campos
 *
 */
public class Reader {

	//vide Character
	public static int EOF = 65535;

	private BufferedReader reader;

	private int linha;

	private int caracter;

	public Reader(File arquivo) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(arquivo));
		linha = 0;
		caracter = Character.LINE_SEPARATOR;
	}

	/**
	 * Retorna o proximo Char válido. (qualquer char excluindo espaço em branco)
	 * @return
	 */
	public char getNextNotWhitespaceChar() {
		do{
			caracter = getNextChar();
		}while(Character.isWhitespace(caracter));
		return (char) caracter;

	}
	
	/**
	 * Retorna o proximo Char, podendo ser espaço em branco
	 * @return
	 */
	public char getNextChar() {
		/*
		 * se o lido anteriormente for separador de linha,
		 * atualiza qual a linha atual
		 */
		
		if(caracter == Character.LINE_SEPARATOR) {
			this.linha++;
		}
		do{
			try {
				caracter = reader.read();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
			if (Character.LINE_SEPARATOR == caracter ) {
				return Character.LINE_SEPARATOR;
			}
			if (caracter == -1) {
				return (char) EOF;
			}
		}while((!Character.isDefined(caracter) || caracter == '\n'|| caracter == '\r'|| caracter == '\t'));
		return (char) caracter;

	}

	public static void main(String[] args) throws IOException {
		Reader reader  = new Reader(new File("util"+File.separator+"teste.txt"));

		for (int i = 0; i < 20; i++) {
			char x = reader.getNextChar();
			if(x != EOF) {
				System.out.println(x);
				System.out.println("l: "+reader.getLinhaAtual());
				System.out.println("-");
			}else  {
				System.out.println("ssssssss");
				System.out.println("l: "+reader.getLinhaAtual());
			}

		}

	}

	public int getLinhaAtual() {
		return linha;
	}
}
