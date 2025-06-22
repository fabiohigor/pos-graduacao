package br.com.professorisidro.events.service;

import java.util.List;

import br.com.professorisidro.events.model.Session;
import br.com.professorisidro.events.model.Subscription;
import br.com.professorisidro.events.model.User;

public interface ISubscriptionService {
	public Subscription addSubscription(Subscription subscription);
	public List<Subscription> getAllByUser(User user);
	public List<Subscription> getAllBySession(Session session);
}
