package com.qa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CucumberOptions(
        dryRun = false,
        glue = {"classpath:com.qa.steps"},
        features = {"src/main/resources/Features/"},
        tags = "@SINGLE"
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
