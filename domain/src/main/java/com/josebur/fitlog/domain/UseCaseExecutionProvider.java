package com.josebur.fitlog.domain;

import rx.Scheduler;

public interface UseCaseExecutionProvider {
    Scheduler getUseCaseScheduler();
    Scheduler getPostExecuteScheduler();
}
