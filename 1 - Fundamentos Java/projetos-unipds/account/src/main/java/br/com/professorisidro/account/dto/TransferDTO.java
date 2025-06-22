package br.com.professorisidro.account.dto;

public record TransferDTO(Integer debitAccountNumber, Integer creditAccountNumber, Double amount) {

}
