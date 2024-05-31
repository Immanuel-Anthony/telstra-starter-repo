package au.com.telstra.simcardactivator.Controller;


import au.com.telstra.simcardactivator.Entity.SimRequest;
import au.com.telstra.simcardactivator.Entity.SimResponse;
import au.com.telstra.simcardactivator.Service.SimActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimActivationController {

    @Autowired
    private SimActivationService simActivationService;

    @PostMapping("/activate-sim")
    public SimResponse activateSim(@RequestBody SimRequest simRequest){
        return simActivationService.activateSim(simRequest);
    }

}
