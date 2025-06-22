package br.com.professorisidro.account.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.account.model.Account;

public interface AccountRepo extends ListCrudRepository<Account, Integer>{
	

}
