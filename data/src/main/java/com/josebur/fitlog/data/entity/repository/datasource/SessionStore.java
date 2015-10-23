package com.josebur.fitlog.data.entity.repository.datasource;

import com.josebur.fitlog.data.entity.SessionEntity;

public interface SessionStore {
    boolean storeSession(SessionEntity session);
    SessionEntity retrieveSession(int sessionId);
}
