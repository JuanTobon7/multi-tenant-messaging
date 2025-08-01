package multi_tenant_back.tenant_api.CitiesStates.repository;

import multi_tenant_back.tenant_api.CitiesStates.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesRepository extends JpaRepository<StateModel, Integer> {
}
