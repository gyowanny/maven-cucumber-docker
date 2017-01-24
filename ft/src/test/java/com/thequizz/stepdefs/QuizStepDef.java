package com.thequizz.stepdefs;

import com.thequizz.client.QuizClient;
import com.thequizz.model.Location;
import com.thequizz.model.QuizPayload;
import com.thequizz.model.QuizState;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuizStepDef {
    
    private QuizState quizState;
    private QuizClient quizClient;

    @Inject
    public QuizStepDef(QuizState quizState, QuizClient quizClient) {
        this.quizState = quizState;
        this.quizClient = quizClient;
    }

    @Given("^there is a quiz for the location '(.+)'$")
    public void thereIsAQuizForALocationAndId(String location) throws Throwable {
        quizState.setLocation(new Location(location, new Location.Coordinate(100d, 100d)));
    }

    @When("^the user starts a quiz for the location '(.+)'$")
    public void theUserStartsAQuizForALocation(String location) throws Throwable {
        quizClient.startQuiz(location);
    }

    @Then("^response content type should be '(.+)' and status code (\\d+)$")
    public void responseStatusShouldBe(String contentType, int status) throws Throwable {
        assertEquals(contentType, quizClient.getLastResponse().getContentType());
        assertEquals(status, quizClient.getLastResponse().getStatusCode());
    }

    @And("^response body as quiz should be valid$")
    public void responseBodyAsQuizShouldBeValid() throws Throwable {
        QuizPayload response = quizClient.getLastResponse().parseAs(QuizPayload.class);
        assertNotNull(response);
    }

}
