package compilador.lexico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import compilador.util.Reader;
import compilador.util.token.IToken;
import compilador.util.token.Identificador;
import compilador.util.token.PalavraReservada;
import compilador.util.token.PalavrasReservadasUtil;

public class AnalisadorLexico {

	private Reader reader;
	private PalavrasReservadasUtil palavrasReservadasUtil;

	public AnalisadorLexico(File arquivo) throws FileNotFoundException {
		reader = new Reader(arquivo);
		palavrasReservadasUtil = new PalavrasReservadasUtil();
	}
	
	public IToken getNextToken() {
		
		char caracter = reader.getNextNotSpaceChar();
		
		IToken nextToken = null;
		try {
			if ( Character.isLetter(caracter) ) {
				nextToken = getIdentifier(caracter);
//			} else if ( Character.isDigit(caracter) ) {
//				nextToken = getNumber(caracter);
//			} else if ( isQuote(caracter) ) {
//				nextToken = getLiteral();
//			} else if ( isOperator(caracter) ) {
//				nextToken = getOperator(caracter);
//			} else if ( isMarker(caracter) ) {
//				nextToken = getMarker(caracter);
			} else {
//				unknownCharacter(caracter);
			}
		} catch (IOException e) {
			throw new IllegalStateException();
		}
		
		return nextToken;
	}

	private IToken getIdentifier(char firstCharacter) throws IOException {
		StringBuffer token = new StringBuffer();
		token.append(firstCharacter);
		char caracter = Character.UNASSIGNED;
		do{
			caracter = (char)reader.getNextChar();
			if(Character.isWhitespace(caracter) || caracter == Reader.EOF || caracter == Character.LINE_SEPARATOR) {
				break;
			}
			token.append(caracter);
		}while(Character.isLetterOrDigit(caracter));
		
		IToken tokenIdent;
		if (palavrasReservadasUtil.isPalavraReservada(token.toString())) {
			tokenIdent = new PalavraReservada(token.toString(), reader.getLinhaAtual());
		} else {
			tokenIdent = new Identificador(token.toString(), reader.getLinhaAtual());
		}
		return tokenIdent;
	}
	
}
