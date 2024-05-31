package au.com.telstra.simcardactivator.Entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class SimRequest {

    @NonNull
    private String iccid;

    @NonNull
    private String customerEmail;

}
