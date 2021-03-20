package com.qa.config;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {

    public void createConnection(){
        System.out.println("****************** DB Connected ****************");
    }
}
