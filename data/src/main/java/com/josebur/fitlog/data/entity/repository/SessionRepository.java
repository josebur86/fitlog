package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;

// TODO: the repository should save and load domain objects, not entity objects.
public class SessionRepository {
    private final SessionStore sessionStore;

    public SessionRepository(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public boolean saveSession(SessionEntity session) {
        return sessionStore.storeSession(session);
    }
}
