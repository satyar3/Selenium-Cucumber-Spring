package glue.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        dryRun = false,
        glue = {"classpath:com.qa.steps"},
        features = {"src/main/resources/Features/"}
        //tags = "@SINGLE"
)
public class Runner extends AbstractTestNGCucumberTests {
    //-Ddataproviderthreadcount=2
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }
}
