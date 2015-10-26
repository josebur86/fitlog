package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.builders.SessionEntityBuilder;
import com.josebur.fitlog.data.entity.mapper.SessionEntityDomainMapper;
import com.josebur.fitlog.data.entity.mapper.SetEntityDomainMapper;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;
import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SessionRepositoryTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private List<Set> sets;
    private SessionEntityDomainMapper mapper;

    @Before
    public void setup() {
        sets = new ArrayList<>();
        sets.add(new Set(1));
        sets.add(new Set(2));
        sets.add(new Set(3));
        sets.add(new Set(4));
        sets.add(new Set(5));

        mapper = new SessionEntityDomainMapper(new SetEntityDomainMapper());
    }

    @Test
    public void repositoryThrowsIfSessionStoreIsNull() {
        thrown.expect(IllegalArgumentException.class);
        new SessionRepository(null, null);
    }

    @Test
    public void repositoryThrowsIfMapperIsNull() {
        thrown.expect(IllegalArgumentException.class);
        new SessionRepository(mock(SessionStore.class), null);
    }

    @Test
    public void repositoryCanSaveASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        when(sessionStore.storeSession(any(SessionEntity.class))).thenReturn(Observable.just(true));
        SessionRepository repository = new SessionRepository(sessionStore, mapper);

        Session session = new Session("Squat", 5, sets);
        Observable<Boolean> resultObs = repository.saveSession(session);
        SessionEntity entity = new SessionEntityBuilder().withSquatSession().build();
        verify(sessionStore).storeSession(entity);

        resultObs.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean result) {
                assertTrue("saveSession returned false", result);
            }
        });
    }

    @Test
    public void repositoryWillReturnFalseWhenSavingNullSession() {
        SessionRepository repository = new SessionRepository(mock(SessionStore.class), mapper);

        repository.saveSession(null).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean result) {
                assertFalse("result should have been false", result);
            }
        });

    }

    @Test
    public void repositoryCanLoadASession() {
        SessionStore sessionStore = mock(SessionStore.class);
        int sessionId = 1;
        SessionEntity sessionEntity = new SessionEntityBuilder()
                .withSquatSession()
                .withId(sessionId)
                .build();
        when(sessionStore.retrieveSession(anyInt())).thenReturn(Observable.just(sessionEntity));
        SessionRepository repository = new SessionRepository(sessionStore, mapper);

        Observable<Session> sessionObs = repository.loadSession(sessionId);
        verify(sessionStore).retrieveSession(sessionId);
        sessionObs.subscribe(new Action1<Session>() {
            @Override
            public void call(Session session) {
                Session expectedSession = new Session("Squat", 5, sets);
                assertEquals(expectedSession, session);
            }
        });
    }

    @Test
    public void repositoryReturnsNullWhenStoreDoesNotHaveSession() {
        SessionStore sessionStore = mock(SessionStore.class);
        SessionEntity entity = null;
        //noinspection ConstantConditions
        when(sessionStore.retrieveSession(anyInt())).thenReturn(Observable.just(entity));
        SessionRepository repository = new SessionRepository(sessionStore, mapper);

        Observable<Session> sessionObs = repository.loadSession(1);
        sessionObs.subscribe(new Action1<Session>() {
            @Override
            public void call(Session session) {
                assertNull(session);
            }
        });
    }
}
