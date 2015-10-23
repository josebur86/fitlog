package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionBuilder;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;
import com.josebur.fitlog.domain.Session;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SessionRepositoryTest {
    @Test
    public void repositoryCanSaveASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        when(sessionStore.storeSession(any(SessionEntity.class))).thenReturn(true);
        SessionRepository repository = new SessionRepository(sessionStore);

        Session session = new Session("Squat", 5, null);
        boolean result = repository.saveSession(session);

        assertTrue("saveSession returned false", result);
        verify(sessionStore).storeSession(any(SessionEntity.class));
    }

    @Test
    public void repositoryCanLoadASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        int sessionId = 1;
        SessionEntity sessionEntity = new SessionBuilder()
                .withSquatSession()
                .withId(sessionId)
                .build();
        when(sessionStore.retrieveSession(anyInt())).thenReturn(sessionEntity);
        SessionRepository repository = new SessionRepository(sessionStore);

        Session session = repository.loadSession(sessionId);

        verify(sessionStore).retrieveSession(sessionId);
        assertNotNull("session is null", session);
    }
}
