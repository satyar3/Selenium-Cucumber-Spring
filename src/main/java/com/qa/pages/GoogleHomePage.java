package com.qa.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.config.DBConnection;
import com.qa.config.SpringContext;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@ScenarioScope
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class GoogleHomePage extends BasePage {

    @Value("${APP_URL}")
    private String appUrl;

    @FindBy(name = "q")
    private WebElement searchBox;

    public void goTo(){
        this.driver.get(this.appUrl);
        SpringContext.getBean(DBConnection.class).createConnection();
    }

    public void typeSearchTerm(String searchTerm){
        this.searchBox.sendKeys(searchTerm);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    public void quit(){
        this.driver.quit();
    }
}
