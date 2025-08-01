package multi_tenant_back.tenant_api.Barbershops.Base.Service;

import lombok.RequiredArgsConstructor;
import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShops;
import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShopsDto;
import multi_tenant_back.tenant_api.Barbershops.Base.Repository.BarberShopsRepository;
import multi_tenant_back.tenant_api.utils.ExceptionsHandlers.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarberShopsService {
    private final BarberShopsRepository barberShopsRepository;

    public BarberShops createBarberShop(BarberShopsDto dto){
        BarberShops barberShops = new BarberShops(dto);
        return barberShopsRepository.save(barberShops);
    }

    public List<BarberShops> findAllBarberShops(Pageable pageable){
        Page<BarberShops> barberShopsPage = barberShopsRepository.findAll(pageable);

        if (barberShopsPage.isEmpty()) {
            throw new ResourceNotFoundException("No barber shops found");
        }
        return barberShopsPage.getContent();
    }
    public BarberShops updateBarberShop(BarberShopsDto dto, UUID id){
        BarberShops barberShops = new BarberShops(dto);
        barberShops.setId(id);
        if(!barberShopsRepository.existsById(id)){
            throw new ResourceNotFoundException("No such barber shop found with id: " + id);
        }
        return barberShopsRepository.save(barberShops);
    }
    public void deleteBarberShop(UUID id){
        if(!barberShopsRepository.existsById(id)){
            throw new ResourceNotFoundException("No barber shop found with id: " + id);
        }
        barberShopsRepository.deleteById(id);
    }
}
