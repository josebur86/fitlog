package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;

import rx.Observable;

/**
 * SessionStore handles persisting {@link SessionEntity} objects.
 */
public interface SessionStore {
    /**
     * Stores a {@link SessionEntity}.
     * @param session the session to store.
     * @return {@link Observable} to a status boolean.
     */
    Observable<Boolean> storeSession(SessionEntity session);

    /**
     * Retrieves a {@link SessionEntity} with the given ID.
     * @param sessionId the ID of the session to retrieve.
     * @return {@link Observable} to the session.
     */
    Observable<SessionEntity> retrieveSession(int sessionId);
}
