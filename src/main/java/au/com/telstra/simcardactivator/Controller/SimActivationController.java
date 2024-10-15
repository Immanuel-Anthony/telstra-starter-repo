package au.com.telstra.simcardactivator.Controller;


import au.com.telstra.simcardactivator.Entity.SimRequest;
import au.com.telstra.simcardactivator.Entity.SimResponse;
import au.com.telstra.simcardactivator.Service.SimActivationService;
import au.com.telstra.simcardactivator.Service.SimSaveService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SimActivationController {

    @Autowired
    private SimActivationService simActivationService;

    @Autowired
    private SimSaveService simSaveService;

    @PostMapping("/activate-sim")
    public ResponseEntity<?> activateSim(@RequestBody SimRequest simRequest){
        SimResponse simResponse = simActivationService.activateSim(simRequest);
        simRequest.setActive(simResponse.isActivated());
        SimRequest simRequest1 = simSaveService.saveSim(simRequest);
        return new ResponseEntity<>(simResponse.getSuccess() , HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getSimStatus(@PathVariable long id){
        Optional<SimRequest> simStatus = simSaveService.getSimStatus(id);
        return new ResponseEntity<>(simStatus , HttpStatus.OK);
    }

}
