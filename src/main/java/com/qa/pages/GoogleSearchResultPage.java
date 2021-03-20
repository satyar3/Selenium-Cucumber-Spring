package com.qa.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
@ScenarioScope
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class GoogleSearchResultPage extends BasePage {

    @FindBy(css = ".hlcw0c div.g")
    private List<WebElement> searchResult;


   public int getSearchResultCount(){
       System.out.println("Search Result Count is :: "+this.searchResult.size());
       Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
       return this.searchResult.size();
   }
}
