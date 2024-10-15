package au.com.telstra.simcardactivator.repo;

import au.com.telstra.simcardactivator.Entity.SimRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimRepo extends CrudRepository<SimRequest , Long> {

}
