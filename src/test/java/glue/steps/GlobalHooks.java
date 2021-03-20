package glue.steps;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GlobalHooks {

    @PostConstruct
    public void beforeAll(){
        System.out.println("Inside beforeAll");
    }

    @PreDestroy
    public void afterAll(){
        System.out.println("Inside After All");
    }
}
