package com.thequizz.api.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.thequizz.api.handler.QuizHandler;
import com.thequizz.api.handler.StatusHandler;

public class QuizModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StatusHandler.class).in(Scopes.SINGLETON);
        bind(QuizHandler.class).in(Scopes.SINGLETON);
    }
}
