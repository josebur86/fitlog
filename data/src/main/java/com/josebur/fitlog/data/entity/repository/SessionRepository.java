package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;
import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import java.util.ArrayList;
import java.util.List;

public class SessionRepository {
    private final SessionStore sessionStore;

    public SessionRepository(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }

    public boolean saveSession(Session session) {
        List<SetEntity> setEntities = new ArrayList<>();
        for (Set set : session.getSets()) {
            setEntities.add(new SetEntity(set.getSetNumber()));
        }
        SessionEntity entity =
                new SessionEntity(1, 1, 1, 1, session.getRepGoal(), setEntities);
        return sessionStore.storeSession(entity);
    }

    public Session loadSession(int sessionId) {
        SessionEntity entity = sessionStore.retrieveSession(sessionId);
        List<Set> sets = new ArrayList<>();
        for (SetEntity setEntity : entity.getSets()) {
            sets.add(new Set(setEntity.getSetNumber()));
        }
        return new Session("Squat", entity.getRepGoal(), sets);
    }
}
