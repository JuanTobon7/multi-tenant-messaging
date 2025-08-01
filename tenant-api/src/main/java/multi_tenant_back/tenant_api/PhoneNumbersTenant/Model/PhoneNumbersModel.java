package multi_tenant_back.tenant_api.PhoneNumbersTenant.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShops;

import java.util.UUID;

@Entity
@Table(name = "phone_numbers_shop")
@Getter
@Setter
public class PhoneNumbersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long phoneNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barber_shop_id")
    public BarberShops barberShops;
}
