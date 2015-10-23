package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;

public class InMemorySessionStore implements SessionStore {
    private SessionEntity session;

    @Override
    public boolean storeSession(SessionEntity session) {
        this.session = session;
        return true;
    }

    @Override
    public SessionEntity retrieveSession(int sessionId) {
        return session;
    }
}
