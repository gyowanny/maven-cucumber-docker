package com.thequizz.stepdefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thequizz.client.QuizClient;
import com.thequizz.model.StatusResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class StatusStepDef {

    private QuizClient quizClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    public StatusStepDef(QuizClient quizClient) {
        this.quizClient = quizClient;
    }

    @When("^the user invokes the status endpoint$")
    public void theUserInvokesTheStatusEndpoint() throws Throwable {
        quizClient.getStatus();
    }

    @And("^response body should contain status '(.+)'$")
    public void responseBodyShouldContainOK(String expectedStatus) throws Throwable {
        String body = quizClient.getLastResponse().parseAsString();
        StatusResponse statusResponse = objectMapper.readValue(body, StatusResponse.class);
        assertEquals(expectedStatus, statusResponse.getStatus());
    }

}
