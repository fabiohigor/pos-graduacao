package br.com.professorisidro.account.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.account.model.Transaction;

public interface TransactionRepo extends ListCrudRepository<Transaction, Integer>{

}
