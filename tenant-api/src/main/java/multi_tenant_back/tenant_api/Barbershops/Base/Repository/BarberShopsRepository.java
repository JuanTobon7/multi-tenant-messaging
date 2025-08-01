package multi_tenant_back.tenant_api.Barbershops.Base.Repository;

import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface BarberShopsRepository extends JpaRepository<BarberShops, UUID>, JpaSpecificationExecutor<BarberShops> {
}
