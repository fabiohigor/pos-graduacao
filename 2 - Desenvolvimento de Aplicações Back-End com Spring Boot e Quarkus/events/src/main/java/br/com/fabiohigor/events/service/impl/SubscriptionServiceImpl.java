package br.com.fabiohigor.events.service.impl;

import br.com.fabiohigor.events.model.Session;
import br.com.fabiohigor.events.model.Subscription;
import br.com.fabiohigor.events.model.User;
import br.com.fabiohigor.events.repository.SubscriptionRepository;
import br.com.fabiohigor.events.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {


    private SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueID(UUID.randomUUID().toString());
        return repository.save(subscription);
    }

    @Override
    public List<Subscription> getAllUByUser(User user) {
        return repository.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return repository.findByIdSession(session);
    }
}
