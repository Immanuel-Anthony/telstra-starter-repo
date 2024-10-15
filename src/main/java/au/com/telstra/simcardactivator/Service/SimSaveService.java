package au.com.telstra.simcardactivator.Service;

import au.com.telstra.simcardactivator.Entity.SimRequest;
import au.com.telstra.simcardactivator.repo.SimRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimSaveService {

    @Autowired
    private SimRepo simRepo;

    public SimRequest saveSim(SimRequest simRequest){
        return simRepo.save(simRequest);
    }

    public Optional<SimRequest> getSimStatus(long id){
        return simRepo.findById(id);
    }

}
