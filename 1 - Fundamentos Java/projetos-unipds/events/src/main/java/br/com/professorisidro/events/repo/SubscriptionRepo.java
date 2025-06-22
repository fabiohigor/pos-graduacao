package br.com.professorisidro.events.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import br.com.professorisidro.events.model.Session;
import br.com.professorisidro.events.model.Subscription;
import br.com.professorisidro.events.model.SubscriptionID;
import br.com.professorisidro.events.model.User;

public interface SubscriptionRepo extends ListCrudRepository<Subscription, SubscriptionID>{
	public List<Subscription> findByIdUser(User user);
	public List<Subscription> findByIdSession(Session session);
}
