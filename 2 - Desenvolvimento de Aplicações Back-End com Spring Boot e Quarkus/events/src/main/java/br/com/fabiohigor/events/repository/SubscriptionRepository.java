package br.com.fabiohigor.events.repository;

import br.com.fabiohigor.events.model.Session;
import br.com.fabiohigor.events.model.Subscription;
import br.com.fabiohigor.events.model.SubscriptionID;
import br.com.fabiohigor.events.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubscriptionRepository extends ListCrudRepository<Subscription, SubscriptionID> {

    public List<Subscription> findByIdUser(User user);

    public List<Subscription> findByIdSession(Session session);
}
