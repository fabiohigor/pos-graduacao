package br.com.fabiohigor.events.controller;

import br.com.fabiohigor.events.exception.NotFoundException;
import br.com.fabiohigor.events.model.Session;
import br.com.fabiohigor.events.model.Subscription;
import br.com.fabiohigor.events.model.User;
import br.com.fabiohigor.events.service.ISubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private ISubscriptionService service;

    public SubscriptionController(ISubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = service.addSubscription(subscription);
        return ResponseEntity.ok(createdSubscription);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Subscription>> getById(@PathVariable Integer userId) {
        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();
        user.setUserId(userId);
        List<Subscription> subscriptions = service.getAllUByUser(user);
        if (subscriptions.isEmpty()) {
            throw  new NotFoundException("Subscription not found by User " + userId);
        }

        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<Subscription>> getBySessionId(@PathVariable Integer sessionId) {
        if (sessionId == null) {
            return ResponseEntity.badRequest().build();
        }

        Session session = new Session();
        session.setSessionId(sessionId);
        List<Subscription> subscriptions = service.getAllBySession(session);
        if (subscriptions.isEmpty()) {
            throw  new NotFoundException("Subscription not found by sessionId " + sessionId);
        }

        return ResponseEntity.ok(subscriptions);
    }

}
