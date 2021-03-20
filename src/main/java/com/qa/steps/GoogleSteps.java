package com.qa.steps;

import com.qa.pages.GoogleHomePage;
import com.qa.pages.GoogleSearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class GoogleSteps extends ConfigStepDef{
    @Autowired
    private GoogleHomePage googleHomePage;

    @Autowired
    private GoogleSearchResultPage googleSearchResultPage;

    @Given("User is on the home page of google")
    public void userIsOnTheHomePageOfGoogle() {
        this.googleHomePage.goTo();
    }

    @When("User is typing {string}")
    public void userIsTyping(String searchTerm) {
        this.googleHomePage.typeSearchTerm(searchTerm);
    }

    @Then("User is on the Search result page")
    public void userIsOnTheSearchResultPage() {
        getTestContext().testSet("key1", googleSearchResultPage.getSearchResultCount());
    }

    @Then("Close the browser")
    public void closeTheBrowser() {
        System.out.println("Search Result is :--> "+ getTestContext().testGet("Key").toString());
        this.googleHomePage.quit();
    }
}
