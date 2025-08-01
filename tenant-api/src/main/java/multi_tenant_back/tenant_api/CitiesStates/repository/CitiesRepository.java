package multi_tenant_back.tenant_api.CitiesStates.repository;

import multi_tenant_back.tenant_api.CitiesStates.model.CitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<CitiesModel,Long> {
}
