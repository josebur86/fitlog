package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionBuilder;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SessionRepositoryTest {
    @Test
    public void repositoryCanSaveASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        when(sessionStore.storeSession(any(SessionEntity.class))).thenReturn(true);
        SessionRepository repository = new SessionRepository(sessionStore);

        SessionEntity session = new SessionBuilder().withSquatSession().build();
        boolean result = repository.saveSession(session);

        assertTrue("saveSession returned false", result);
        verify(sessionStore).storeSession(session);
    }
}