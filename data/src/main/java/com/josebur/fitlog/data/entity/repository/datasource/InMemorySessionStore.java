package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * In memory implementation of the {@link SessionStore}.
 *
 * Note: This store comes pre-populated with a session of
 * 5x5 Squats with the ID of 999.
 */
public class InMemorySessionStore implements SessionStore {
    private Map<Integer, SessionEntity> sessions;

    public InMemorySessionStore() {
        sessions = new HashMap<>();

        List<SetEntity> sets = new ArrayList<>();
        sets.add(new SetEntity(1));
        sets.add(new SetEntity(2));
        sets.add(new SetEntity(3));
        sets.add(new SetEntity(4));
        sets.add(new SetEntity(5));
        SessionEntity session = new SessionEntity(999, 1, 1, 1, 5, sets);
        sessions.put(session.getId(), session);
    }

    @Override
    public Observable<Boolean> storeSession(SessionEntity session) {
        sessions.put(session.getId(), session);
        return Observable.just(true);
    }

    @Override
    public Observable<SessionEntity> retrieveSession(int sessionId) {
        return Observable.just(sessions.get(sessionId));
    }
}
