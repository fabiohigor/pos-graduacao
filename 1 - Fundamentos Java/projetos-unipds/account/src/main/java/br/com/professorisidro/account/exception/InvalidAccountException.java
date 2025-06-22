package br.com.professorisidro.account.exception;

public class InvalidAccountException extends RuntimeException{
	public InvalidAccountException(String msg) {
		super(msg);
	}

}