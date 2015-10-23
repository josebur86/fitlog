package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionEntityBuilder;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;
import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SessionRepositoryTest {
    private List<Set> sets;
    @Before
    public void setup() {
        sets = new ArrayList<>();
        sets.add(new Set(1));
        sets.add(new Set(2));
        sets.add(new Set(3));
        sets.add(new Set(4));
        sets.add(new Set(5));
    }

    @Test
    public void repositoryCanSaveASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        when(sessionStore.storeSession(any(SessionEntity.class))).thenReturn(true);
        SessionRepository repository = new SessionRepository(sessionStore);

        Session session = new Session("Squat", 5, sets);
        boolean result = repository.saveSession(session);

        assertTrue("saveSession returned false", result);
        SessionEntity entity = new SessionEntityBuilder().withSquatSession().build();
        verify(sessionStore).storeSession(entity);
    }

    @Test
    public void repositoryCanLoadASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        int sessionId = 1;
        SessionEntity sessionEntity = new SessionEntityBuilder()
                .withSquatSession()
                .withId(sessionId)
                .build();
        when(sessionStore.retrieveSession(anyInt())).thenReturn(sessionEntity);
        SessionRepository repository = new SessionRepository(sessionStore);

        Session session = repository.loadSession(sessionId);

        verify(sessionStore).retrieveSession(sessionId);
        Session expectedSession = new Session("Squat", 5, sets);
        assertEquals(expectedSession, session);
    }
}
