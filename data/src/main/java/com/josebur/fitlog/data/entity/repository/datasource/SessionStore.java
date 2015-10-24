package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;

/**
 * SessionStore handles persisting {@link SessionEntity} objects.
 */
// TODO: consider returning Observables here.
public interface SessionStore {
    /**
     * Stores a {@link SessionEntity}.
     * @param session the session to store
     * @return true if successful, false otherwise
     */
    boolean storeSession(SessionEntity session);

    /**
     * Retrieves a {@link SessionEntity} with the given ID.
     * @param sessionId the ID of the session to retrieve.
     * @return the session if successful, null otherwise.
     */
    SessionEntity retrieveSession(int sessionId);
}
