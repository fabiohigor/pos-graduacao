package br.com.fabiohigor.events.repository;

import br.com.fabiohigor.events.model.Session;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends ListCrudRepository<Session, Integer> {


}
