package au.com.telstra.simcardactivator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class SimRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String iccid;

    @NonNull
    private String customerEmail;

    private boolean active;

    public SimRequest(String iccid , String customerEmail , boolean active){
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

}
