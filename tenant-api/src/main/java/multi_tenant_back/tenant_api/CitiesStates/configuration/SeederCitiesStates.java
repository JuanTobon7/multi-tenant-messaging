package multi_tenant_back.tenant_api.CitiesStates.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import multi_tenant_back.tenant_api.CitiesStates.Service.CitiesService;
import multi_tenant_back.tenant_api.CitiesStates.Service.StatesService;
import multi_tenant_back.tenant_api.CitiesStates.model.StateCitiesDTO;
import multi_tenant_back.tenant_api.CitiesStates.model.StateModel;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SeederCitiesStates {
    private static int counter = 0;
    private final ObjectMapper objectMapper;
    private final StatesService statesService;
    private final CitiesService citiesService;
    @Value("classpath:/data_cities_states_geo.json")
    private Resource resource;

    @PostConstruct
    public void loadJsonCitiesStates() throws IOException {
        try (InputStream inputStream = resource.getInputStream()) {
            TypeReference<List<StateCitiesDTO>> typeRef = new TypeReference<>() {
            };
            List<StateCitiesDTO> departments = objectMapper.readValue(inputStream, typeRef);
            for (StateCitiesDTO dto : departments) {
                try {
                    System.out.println(objectMapper.writeValueAsString(dto));
                    StateModel state = statesService.createStates(dto.getState(), dto.getId());
                    int quantityCities = citiesService.createCities(dto.getCities(), state).size();
                    SeederCitiesStates.counter += 1 +  quantityCities;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Geo data loaded");
        }
    }
}
