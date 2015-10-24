package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionEntityBuilder;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InMemorySessionStoreTest {
    @Test
    public void sessionCanBeStoredAndRetrieved() {
        final SessionEntity session = new SessionEntityBuilder().withSquatSession().build();
        SessionStore store = new InMemorySessionStore();

        Observable<Boolean> result = store.storeSession(session);
        result.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean result) {
                assertTrue("storeSession returned false", result);
            }
        });

        final Observable<SessionEntity> retrievedSession = store.retrieveSession(session.getId());
        retrievedSession.subscribe(new Action1<SessionEntity>() {
            @Override
            public void call(SessionEntity sessionEntity) {
                assertEquals(session, sessionEntity);
            }
        });

    }

    @Test
    public void retrieveThePrepopulatedSession() {
        SessionStore store = new InMemorySessionStore();

        Observable<SessionEntity> session = store.retrieveSession(999);

        final SessionEntity expectedSession = new SessionEntityBuilder()
                .withSquatSession()
                .build();
        session.subscribe(new Action1<SessionEntity>() {
            @Override
            public void call(SessionEntity sessionEntity) {
                assertEquals(expectedSession, sessionEntity);
            }
        });
    }
}
