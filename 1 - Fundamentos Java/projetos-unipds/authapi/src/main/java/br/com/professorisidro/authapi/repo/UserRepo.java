package br.com.professorisidro.authapi.repo;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.authapi.model.User;

public interface UserRepo extends ListCrudRepository<User, Integer>{

	public Optional<User> findByUsername(String username);
}
