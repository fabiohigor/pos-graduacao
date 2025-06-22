package br.com.professorisidro.events.service;

import java.util.List;

import br.com.professorisidro.events.model.Session;

public interface ISessionService {
	public Session addSession(Session session);
	public Session getSessionById(Integer id);
	public List<Session> getAllSessions();
}
