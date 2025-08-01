package multi_tenant_back.tenant_api.PhoneNumbersTenant.repository;
import multi_tenant_back.tenant_api.PhoneNumbersTenant.Model.PhoneNumbersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbersModel, Long> {
}
