package multi_tenant_back.tenant_api.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesModel, Integer> {
}
