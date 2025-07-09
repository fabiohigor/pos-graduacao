package br.com.fabiohigor.events.controller;

import br.com.fabiohigor.events.exception.NotFoundException;
import br.com.fabiohigor.events.model.Session;
import br.com.fabiohigor.events.service.ISessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private ISessionService service;

    public SessionController(ISessionService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Session> addSession(@RequestBody Session session) {
        return ResponseEntity.ok(this.service.addSession(session));
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = service.getAllSessions();
        if (sessions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSession(@PathVariable("sessionId") String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Integer id = Integer.parseInt(sessionId);
            Session session = service.getSessionById(id);

            if (session == null) {
                throw new NotFoundException("Session not found with ID: " + sessionId);
            }
            return ResponseEntity.ok(session);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}

