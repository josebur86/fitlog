package com.josebur.fitlog.domain.usecase;

import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;
import com.josebur.fitlog.domain.UseCaseExecutionProvider;

import org.junit.Test;

import java.util.Collections;

import repository.SessionRepository;
import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetSetsForSessionTest {
    @Test
    // TODO: this test is doing too much.
    public void getSetsForSessionWillUseARepository() {
        Session session = new Session("Squat", 5, Collections.<Set>emptyList());
        SessionRepository repository = mock(SessionRepository.class);
        when(repository.loadSession(anyInt()))
                .thenReturn(Observable.just(session));
        UseCaseExecutionProvider provider = mock(UseCaseExecutionProvider.class);
        TestScheduler scheduler = new TestScheduler();
        when(provider.getUseCaseScheduler()).thenReturn(scheduler);
        when(provider.getPostExecuteScheduler()).thenReturn(scheduler);
        GetSetsForSession useCase = new GetSetsForSession(repository, provider);

        TestSubscriber<Session> subscriber = new TestSubscriber<>();
        useCase.execute(subscriber);

        verify(provider, atLeastOnce()).getUseCaseScheduler();
        verify(provider, atLeastOnce()).getPostExecuteScheduler();
        scheduler.triggerActions();
        subscriber.assertValue(session);
        subscriber.assertCompleted();
        subscriber.assertUnsubscribed();
    }
}
