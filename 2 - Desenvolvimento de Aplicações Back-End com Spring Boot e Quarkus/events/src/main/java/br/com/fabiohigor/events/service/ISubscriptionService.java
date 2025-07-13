package br.com.fabiohigor.events.service;

import br.com.fabiohigor.events.model.Session;
import br.com.fabiohigor.events.model.Subscription;
import br.com.fabiohigor.events.model.User;

import java.util.List;

public interface ISubscriptionService {

    public Subscription addSubscription(Subscription subscription);
    public List<Subscription> getAllUByUser(User user);
    public List<Subscription> getAllBySession(Session session);
}
