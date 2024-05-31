package au.com.telstra.simcardactivator.Service;

import au.com.telstra.simcardactivator.Entity.SimRequest;
import au.com.telstra.simcardactivator.Entity.SimResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class SimActivationService {

    private static final String ActuatorURL = "http://localhost:8444/actuate";

    private RestTemplate restTemplate;

    public SimResponse activateSim(SimRequest simRequest){
        ResponseEntity<SimResponse> responseEntity = restTemplate.postForEntity(ActuatorURL , simRequest , SimResponse.class);
        return responseEntity.getBody();
    }

}
