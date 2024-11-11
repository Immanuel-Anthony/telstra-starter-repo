package stepDefinitions;

import au.com.telstra.simcardactivator.Entity.SimRequest;
import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private SimRequest simRequest;

    private ResponseEntity<String> responseEntity;

    @Given("A working sim card is given")
    public void workingSim(){
        simRequest = new SimRequest("1255789453849037777" , "xyz@gmail.com" , true);
    }

    @Given("A non working sim card is given")
    public void nonWorkingSim() {
        simRequest = new SimRequest("8944500102198304826", "zyx@gmail.com", false);
    }

    @When("Request sent to activate sim card")
    public void requestToActivateSim(){
        responseEntity = restTemplate.exchange(
                "http://localhost:8444/actuate",
                HttpMethod.POST,
                new HttpEntity<>(simRequest),
                String.class);
    }

    @Then("Sim card should be activated")
    public void simShouldBeActivated(){
        String responseBody = responseEntity.getBody();
        assertTrue(responseBody.contains("\"success\":true"));
    }

    @Then("Sim card should not be activated")
    public void simShouldNotBeActivated(){
        String responseBody = responseEntity.getBody();
        assertTrue(responseBody.contains("\"success\":false"));
    }

}