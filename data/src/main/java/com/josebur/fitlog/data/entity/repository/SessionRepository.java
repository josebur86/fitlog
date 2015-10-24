package com.josebur.fitlog.data.entity.repository;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;
import com.josebur.fitlog.data.entity.mapper.SessionEntityDomainMapper;
import com.josebur.fitlog.data.entity.repository.datasource.SessionStore;
import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import java.util.ArrayList;
import java.util.List;

// TODO: this class should use a mapper to create instances

/**
 * SessionRepository is the only method for persistence of {@link Session}
 * instances. The client will only interact with a SessionRepository
 * when requesting or storing Session objects.
 */
public class SessionRepository {
    private final SessionStore sessionStore;
    private final SessionEntityDomainMapper mapper;

    /**
     * Creates a SessionRepository.
     * @param sessionStore a storage mechanism for the repository to use.
     * @throws IllegalArgumentException if the sessionStore or mapper is null.
     */
    public SessionRepository(SessionStore sessionStore, SessionEntityDomainMapper mapper) {
        if (sessionStore == null) throw new IllegalArgumentException("sessionStore");
        if (mapper == null) throw new IllegalArgumentException("mapper");
        this.sessionStore = sessionStore;
        this.mapper = mapper;
    }

    /**
     * Attempts to save the given {@link Session}.
     * @param session the session to save.
     * @return true if the session was saved successfully, false otherwise.
     */
    public boolean saveSession(Session session) {
        if (session == null) return false;
        SessionEntity entity = mapper.toEntity(session);
        return sessionStore.storeSession(entity);
    }

    /**
     * Attempts to load a {@link Session}.
     * @param sessionId the id of the session to load.
     * @return the session with the given sessionId if successful, null otherwise.
     */
    public Session loadSession(int sessionId) {
        SessionEntity entity = sessionStore.retrieveSession(sessionId);
        if (entity == null) return null;

        return mapper.toDomainModel(entity);
    }
}
