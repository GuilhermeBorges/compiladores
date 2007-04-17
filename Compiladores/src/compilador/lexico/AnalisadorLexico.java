package compilador.lexico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import compilador.util.PalavrasReservadasUtil;
import compilador.util.Reader;
import compilador.util.Util;
import compilador.util.token.IToken;
import compilador.util.token.IdentificadorToken;
import compilador.util.token.NumeroToken;
import compilador.util.token.PalavraReservadaToken;

public class AnalisadorLexico {

	private Reader reader;
	private PalavrasReservadasUtil palavrasReservadasUtil;

	public AnalisadorLexico(File arquivo) throws FileNotFoundException {
		reader = new Reader(arquivo);
		palavrasReservadasUtil = new PalavrasReservadasUtil();
	}
	
	public IToken getNextToken() {
		
		char caracter = reader.getNextNotWhitespaceChar();
		IToken nextToken = null;
		try {
			if ( Character.isLetter(caracter) ) {
				nextToken = getIdentificador(caracter);
			} else if ( Character.isDigit(caracter) ) {
				nextToken = getNumero(caracter);
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

	private IToken getNumero(char firstCaracter) {
		StringBuffer token = new StringBuffer();
		token.append(firstCaracter);
		char caracter = reader.getNextChar();
		while(!Character.isWhitespace(caracter) && (caracter != Reader.EOF)) {
			token.append(caracter);
			caracter = reader.getNextChar();
		}
		//FIXME: Correcao do numero vai ser feita aqui se ele for inválido??
		return new NumeroToken(token.toString(), reader.getLinhaAtual(), Util.isInteiroValido(token.toString()));
	}
	
	private IToken getIdentificador(char firstCaracter) throws IOException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(firstCaracter);
		char caracter = reader.getNextChar();
		
		while(Character.isLetterOrDigit(caracter)){
			buffer.append(caracter);
			caracter = reader.getNextChar();
		};
		
		IToken tokenIdent;
		if (palavrasReservadasUtil.isPalavraReservada(buffer.toString())) {
			tokenIdent = new PalavraReservadaToken(buffer.toString(), reader.getLinhaAtual());
		} else {
			tokenIdent = new IdentificadorToken(buffer.toString(), reader.getLinhaAtual());
		}
		return tokenIdent;
	}
	
}
