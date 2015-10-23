package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;
import com.josebur.fitlog.domain.Session;

import java.util.Collections;

public class SessionRepository {
    private final SessionStore sessionStore;

    public SessionRepository(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public boolean saveSession(Session session) {

        SessionEntity entity =
                new SessionEntity(1, 1, 1, 1, session.getRepGoal(), Collections.<SetEntity>emptyList());

        return sessionStore.storeSession(entity);
    }
}
