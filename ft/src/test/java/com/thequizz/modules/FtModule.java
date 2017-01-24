package com.thequizz.modules;

import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.thequizz.client.QuizClient;

public class FtModule extends AbstractModule {

    @Override
    protected void configure() {
        System.out.println("###### API URL: "+System.getProperty("apiUrl"));
        Names.bindProperties(binder(), System.getProperties());
        bind(HttpRequestFactory.class).toInstance(
                new NetHttpTransport().createRequestFactory(request -> request.setParser(new JsonObjectParser(new JacksonFactory())))
        );
        bind(QuizClient.class);
    }

}
