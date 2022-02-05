package br.example.com.exception;

public class FaixaInvalidaException extends RuntimeException {
	
	private static final long serialVersionUID = -1351960506515981151L;

	public FaixaInvalidaException() {
		super();
	}
	
	public FaixaInvalidaException(String message) {
		super(message);
	}
}
