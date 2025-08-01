package multi_tenant_back.tenant_api.CitiesStates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StateCitiesDTO {
    private int id;
    @JsonProperty("departament")
    private String state;
    private List<String> cities;
}
