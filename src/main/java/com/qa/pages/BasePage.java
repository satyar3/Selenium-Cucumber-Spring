package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    @Autowired
    WebDriver driver;

    @PostConstruct
    public void init(){
        PageFactory.initElements(this.driver, this);
    }
}
