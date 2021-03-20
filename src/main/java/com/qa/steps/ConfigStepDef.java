package com.qa.steps;

import com.qa.config.TestContext;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static com.qa.config.TestContext.CONTEXT;

@CucumberContextConfiguration
@ContextConfiguration("classpath:spring-config.xml")
public abstract class ConfigStepDef {

    public TestContext getTestContext(){
        return CONTEXT;
    }
}
