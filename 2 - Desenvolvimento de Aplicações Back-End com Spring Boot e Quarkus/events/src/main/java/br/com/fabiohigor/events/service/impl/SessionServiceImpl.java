package br.com.fabiohigor.events.service.impl;

import br.com.fabiohigor.events.exception.NotFoundException;
import br.com.fabiohigor.events.model.Session;
import br.com.fabiohigor.events.repository.SessionRepository;
import br.com.fabiohigor.events.service.ISessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    private SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Session addSession(Session session) {
        return repository.save(session);
    }

    @Override
    public Session getSessionById(Integer sessionId) {
        return repository.findById(sessionId)
                .orElseThrow(() -> new NotFoundException("Session not found with ID: " + sessionId));
    }

    @Override
    public List<Session> getAllSessions() {
        return repository.findAll();
    }
}
