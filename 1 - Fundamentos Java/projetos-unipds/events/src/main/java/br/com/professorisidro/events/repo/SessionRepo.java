package br.com.professorisidro.events.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.events.model.Session;

public interface SessionRepo extends ListCrudRepository<Session, Integer>{

}
