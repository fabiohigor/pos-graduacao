package br.com.professorisidro.events.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.professorisidro.events.model.Session;
import br.com.professorisidro.events.model.Subscription;
import br.com.professorisidro.events.model.User;
import br.com.professorisidro.events.repo.SubscriptionRepo;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService{
	
	private SubscriptionRepo repo;
	
	public SubscriptionServiceImpl(SubscriptionRepo repo) {
		this.repo = repo;
	}

	@Override
	public Subscription addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		subscription.setCratedAt(LocalDateTime.now());
		subscription.setUniqueID(UUID.randomUUID().toString());
		return repo.save(subscription);
	}

	@Override
	public List<Subscription> getAllByUser(User user) {
		// TODO Auto-generated method stub
		return repo.findByIdUser(user);
	}

	@Override
	public List<Subscription> getAllBySession(Session session) {
		// TODO Auto-generated method stub
		return repo.findByIdSession(session);
	}

}
