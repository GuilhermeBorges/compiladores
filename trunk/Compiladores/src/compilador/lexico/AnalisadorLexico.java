package compilador.lexico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import compilador.util.OperadoresUtil;
import compilador.util.PalavrasReservadasUtil;
import compilador.util.Reader;
import compilador.util.Util;
import compilador.util.token.IToken;
import compilador.util.token.IdentificadorToken;
import compilador.util.token.LiteralToken;
import compilador.util.token.NumeroToken;
import compilador.util.token.OperadorToken;
import compilador.util.token.PalavraReservadaToken;

public class AnalisadorLexico {

	private Reader reader;
	private PalavrasReservadasUtil palavrasReservadasUtil;
	private OperadoresUtil operadorUtil;

	private static final Character ASPAS_DUPLAS = new Character('"');
	
	public AnalisadorLexico(File arquivo) throws FileNotFoundException {
		reader = new Reader(arquivo);
		palavrasReservadasUtil = new PalavrasReservadasUtil();
		operadorUtil = new OperadoresUtil();
	}
	
	public IToken getNextToken() {
		
		char caracter = reader.getNextNotWhitespaceChar();
		IToken nextToken = null;
		try {
			if ( Character.isLetter(caracter) ) {
				nextToken = getIdentificador(caracter);
			} else if ( Character.isDigit(caracter) ) {
				nextToken = getNumero(caracter);
			} else if ( isAspasDuplas(caracter) ) {
				nextToken = getLiteral();
			} else if ( operadorUtil.isOperador(caracter) ) {
				nextToken = getOperator(caracter);
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

	private IToken getOperator(char caracter) {
		return new OperadorToken(Character.toString(caracter), reader.getLinhaAtual());
	}

	private IToken getLiteral() {
		StringBuffer literalString = new StringBuffer();
		char literalCharacter = reader.getNextChar();
		
		while(!(literalCharacter != Character.LINE_SEPARATOR) && !isAspasDuplas(literalCharacter)) {
			literalString.append(literalCharacter);
			literalCharacter = reader.getNextChar();
		}
		
		if(!isAspasDuplas(literalCharacter)) {
			literalString.append(literalCharacter);
		}
		//se o ultimo literal lido, foi aspas duplas, significa que em um literal válido, correto
		return new LiteralToken(literalString.toString(), reader.getLinhaAtual(), isAspasDuplas(literalCharacter));
	}

	private boolean isAspasDuplas(char caracter) {
		return ASPAS_DUPLAS.equals(caracter);
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
