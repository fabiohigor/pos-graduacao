package br.com.professorisidro.events.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.events.model.Conference;

public interface ConferenceRepo extends ListCrudRepository<Conference, Integer>{

}
