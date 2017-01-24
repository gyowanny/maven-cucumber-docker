package com.thequizz.client;

import com.google.api.client.http.HttpResponse;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;
import javax.inject.Named;

import static java.util.Collections.emptyMap;

@ScenarioScoped
public class QuizClient {
    private final RequestBuilder requestBuilder;
    private final String apiUrl;
    private HttpResponse lastResponse;

    @Inject
    public QuizClient(
            RequestBuilder requestBuilder,
            @Named("apiUrl") String apiUrl
    ) {
        this.requestBuilder = requestBuilder;
        this.apiUrl = apiUrl;
    }

    public HttpResponse getLastResponse() {
        return lastResponse;
    }

    public void startQuiz(String location) throws Exception {
        lastResponse = requestBuilder.execute("PUT", apiUrl + "/quiz", emptyMap(), location);
    }

    public void getStatus() throws Exception {
        lastResponse = requestBuilder.execute("GET", apiUrl + "/private/status", emptyMap(), null);
    }
}
