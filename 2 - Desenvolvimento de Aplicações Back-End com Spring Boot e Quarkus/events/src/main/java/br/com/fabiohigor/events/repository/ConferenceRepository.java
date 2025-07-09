package br.com.fabiohigor.events.repository;

import br.com.fabiohigor.events.model.Conference;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConferenceRepository extends ListCrudRepository<Conference,Integer> {
}
