package multi_tenant_back.tenant_api.Barbershops.Base.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import multi_tenant_back.tenant_api.CitiesStates.model.CitiesModel;

import java.util.UUID;

@Entity
@Table(name = "barber_shops")
@Getter
@Setter
@RequiredArgsConstructor
public class BarberShops {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private CitiesModel city;
    private String address;

    public BarberShops(BarberShopsDto dto){
        this.city = dto.getCity();
        this.name = dto.getName();
        this.address = dto.getAddress();
    }
}
