package au.com.telstra.simcardactivator.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimResponse {

    @JsonProperty("success")
    private String success;

    @JsonCreator
    public SimResponse(@JsonProperty("success") String success) {
        this.success = success;
    }

    public boolean isActivated() {
        return "true".equalsIgnoreCase(success);
    }
}
