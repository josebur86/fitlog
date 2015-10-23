package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionEntityBuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InMemorySessionStoreTest {
    @Test
    public void sessionCanBeStoredAndRetrieved() {
        SessionEntity session = new SessionEntityBuilder().withSquatSession().build();
        SessionStore store = new InMemorySessionStore();

        boolean result = store.storeSession(session);
        assertTrue("storeSession returned false", result);

        SessionEntity retrievedSession = store.retrieveSession(session.getId());

        // TODO: implement equals so that assertEquals can be called once here
        assertEquals(session.getUserId(), retrievedSession.getUserId());
    }
}
