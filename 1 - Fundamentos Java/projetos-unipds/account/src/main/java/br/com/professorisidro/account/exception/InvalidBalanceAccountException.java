package br.com.professorisidro.account.exception;

public class InvalidBalanceAccountException extends RuntimeException{
	public InvalidBalanceAccountException(String msg) {
		super(msg);
	}

}
