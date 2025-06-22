package br.com.professorisidro.events.repo;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.events.model.User;

public interface UserRepo extends ListCrudRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
}
