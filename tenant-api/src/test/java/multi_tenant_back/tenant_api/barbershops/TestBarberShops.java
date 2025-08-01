package multi_tenant_back.tenant_api.barbershops;

import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShops;
import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShopsDto;
import multi_tenant_back.tenant_api.Barbershops.Base.Repository.BarberShopsRepository;
import multi_tenant_back.tenant_api.Barbershops.Base.Service.BarberShopsService;
import multi_tenant_back.tenant_api.CitiesStates.model.CitiesModel;
import multi_tenant_back.tenant_api.CitiesStates.repository.CitiesRepository;
import multi_tenant_back.tenant_api.PhoneNumbersTenant.Model.PhoneNumbersModel;
import multi_tenant_back.tenant_api.PhoneNumbersTenant.Service.PhoneNumbersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
class TestBarberShopsCreate {

    @Mock
    private BarberShopsRepository barberRepository;

    @Mock
    private CitiesRepository citiesRepository;

    @Mock
    private PhoneNumbersService phoneNumbersService;

    @InjectMocks
    private BarberShopsService barberShopsService;

    @Test
    void testCreateBarberShop_withCityAndPhone() throws Exception {
        // Arrange
        Long cityId = 1L;
        String barberShopName = "Barbería Juan";
        String address = "Calle Falsa 123";
        Long phoneNumber = 12345678901L;

        // Fake ciudad ya existente
        CitiesModel city = new CitiesModel();
        city.setId(cityId);
        city.setName("Medellín");

        // DTO que viene del frontend
        BarberShopsDto dto = new BarberShopsDto();
        dto.setName(barberShopName);
        dto.setAddress(address);
        dto.setCity(city);
        dto.setPhone(phoneNumber);

        // Entidad esperada de barbería
        BarberShops savedBarberShop = new BarberShops();
        UUID idBarberShop = UUID.randomUUID();
        savedBarberShop.setId(idBarberShop);
        savedBarberShop.setName(barberShopName);
        savedBarberShop.setAddress(address);
        savedBarberShop.setCity(city);

        // Teléfono esperado
        PhoneNumbersModel savedPhone = new PhoneNumbersModel();
        UUID idPhone = UUID.randomUUID();
        savedPhone.setId(idPhone);
        savedPhone.setPhoneNumber(phoneNumber);
        savedPhone.setBarberShops(savedBarberShop);

        // Mocks
        lenient().when(citiesRepository.findById(cityId)).thenReturn(Optional.of(city));
        lenient().when(barberRepository.save(any(BarberShops.class))).thenReturn(savedBarberShop);
        lenient().when(phoneNumbersService.createPhoneNumber(phoneNumber, savedBarberShop)).thenReturn(savedPhone);

        // Act
        BarberShops result = barberShopsService.createBarberShop(dto);

        // Assert
        assertNotNull(result);
        assertEquals(barberShopName, result.getName());
        assertEquals(address, result.getAddress());
        assertEquals(city, result.getCity());
    }
}
