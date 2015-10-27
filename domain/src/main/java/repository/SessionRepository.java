package repository;

import com.josebur.fitlog.domain.Session;

import rx.Observable;

public interface SessionRepository {
    Observable<Boolean> saveSession(Session session);
    Observable<Session> loadSession(int sessionId);
}
