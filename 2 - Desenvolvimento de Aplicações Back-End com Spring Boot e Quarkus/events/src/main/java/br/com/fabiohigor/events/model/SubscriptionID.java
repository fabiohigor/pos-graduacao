package br.com.fabiohigor.events.model;

import jakarta.persistence.*;

@Embeddable
public class SubscriptionID {

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
