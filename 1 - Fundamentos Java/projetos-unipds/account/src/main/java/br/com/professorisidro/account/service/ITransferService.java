package br.com.professorisidro.account.service;

import br.com.professorisidro.account.dto.TransferDTO;
import br.com.professorisidro.account.model.Transaction;

public interface ITransferService {
	public Transaction transferValues(TransferDTO transferDto);

}
