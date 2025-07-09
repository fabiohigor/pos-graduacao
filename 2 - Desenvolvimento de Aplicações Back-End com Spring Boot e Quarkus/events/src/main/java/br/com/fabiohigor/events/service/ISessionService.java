package br.com.fabiohigor.events.service;

import br.com.fabiohigor.events.model.Session;

import java.util.List;

public interface ISessionService {

    public Session addSession(Session session);
    public Session getSessionById(Integer sessionId);
    public List<Session> getAllSessions();

}
