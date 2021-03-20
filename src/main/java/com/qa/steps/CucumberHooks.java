package com.qa.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class CucumberHooks {

    @Autowired
    WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("In beforeScenario of "+scenario.getName());
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        System.out.println("In beforeStep of "+scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        System.out.println("In afterStep of "+scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println("In afterScenario of "+scenario.getName());
    }
}
