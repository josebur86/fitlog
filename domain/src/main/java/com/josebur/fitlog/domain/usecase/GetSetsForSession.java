package com.josebur.fitlog.domain.usecase;

import com.josebur.fitlog.domain.UseCaseExecutionProvider;

import repository.SessionRepository;
import rx.Subscriber;

public class GetSetsForSession {
    private final SessionRepository repository;
    private final UseCaseExecutionProvider provider;

    public GetSetsForSession(SessionRepository repository, UseCaseExecutionProvider provider) {
        this.repository = repository;
        this.provider = provider;
    }

    public void execute(Subscriber subscriber) {
        repository.loadSession(999)
                .subscribeOn(provider.getUseCaseScheduler())
                .observeOn(provider.getPostExecuteScheduler())
                .subscribe(subscriber);
    }
}
