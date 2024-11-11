package au.com.telstra.simcardactivator.controller;


import au.com.telstra.simcardactivator.Entity.SimRequest;
import au.com.telstra.simcardactivator.Entity.SimResponse;
import au.com.telstra.simcardactivator.Service.SimActivationService;
import au.com.telstra.simcardactivator.Service.SimSaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SimActivationController {

    private final SimActivationService simActivationService;

    private final SimSaveService simSaveService;

    public SimActivationController(SimActivationService simActivationService , SimSaveService simSaveService){
        this.simActivationService = simActivationService;
        this.simSaveService = simSaveService;
    }

    @PostMapping("/activate-sim")
    public ResponseEntity<String> activateSim(@RequestBody SimRequest simRequest){
        SimResponse simResponse = simActivationService.activateSim(simRequest);
        simRequest.setActive(simResponse.isActivated());
        simSaveService.saveSim(simRequest);
        return new ResponseEntity<>(simResponse.getSuccess() , HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<SimRequest>> getSimStatus(@PathVariable long id){
        Optional<SimRequest> simStatus = simSaveService.getSimStatus(id);
        return new ResponseEntity<>(simStatus , HttpStatus.OK);
    }

}
