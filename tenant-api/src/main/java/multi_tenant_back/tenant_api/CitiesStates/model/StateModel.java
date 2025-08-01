package multi_tenant_back.tenant_api.CitiesStates.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "states")
@Getter
@Setter
public class StateModel {
    @Id
    private Integer id;
    private String name;
}
