package multi_tenant_back.tenant_api.Barbershops.Base.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import multi_tenant_back.tenant_api.CitiesStates.model.CitiesModel;

import java.util.UUID;

@Getter
@Setter
public class BarberShopsDto {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotNull
    private Long phone;
    @NotNull
    private CitiesModel city;
}
