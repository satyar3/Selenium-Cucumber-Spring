package glue.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class CucumberHooks {

    @Autowired
    WebDriver driver;

    @Before
    public void beforeScenario(){
        System.out.println("In beforeScenario");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("In beforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("In afterStep");
    }

    @After
    public void afterScenario(){
        System.out.println("In afterScenario");
    }
}
