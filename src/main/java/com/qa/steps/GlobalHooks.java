package com.qa.steps;

import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

@Component
public class GlobalHooks {

    @PostConstruct
    public void beforeAll() {
        System.out.println("Inside beforeAll");
    }

    @PreDestroy
    public void afterAll() {
        System.out.println("Inside After All");

        //https://medium.com/@bcarunmail/set-up-and-run-cucumber-tests-in-spring-boot-application-d0c149d26220

        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/cucumber-report.json");
        //jsonFiles.add("cucumber-reports/report.json");


        String buildNumber = "1";
        String projectName = "CucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optional configuration - check javadoc for details
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        // do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
        // addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");

        /*// optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("properties-1.properties");
        classificationFiles.add("properties-2.properties");
        configuration.addClassificationFiles(classificationFiles);*/

        // optionally specify qualifiers for each of the report json files
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        configuration.setQualifier("cucumber-report-1", "First report");
        configuration.setQualifier("cucumber-report-2", "Second report");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
//

//        String buildNumber = "101";
//        String projectName = "Live Demo Project";
//        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
//        configuration.setBuildNumber(buildNumber);
//
//        configuration.addClassifications("Browser", "Firefox");
//        configuration.addClassifications("Branch", "release/1.0");
//        configuration.setSortingMethod(SortingMethod.NATURAL);
//        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
//        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
//        configuration.setQualifier("sample", "Chrome 80, mobile");
//        // points to the demo trends which is not used for other tests
//        configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));
//
//        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//        reportBuilder.generateReports();
    }
}
