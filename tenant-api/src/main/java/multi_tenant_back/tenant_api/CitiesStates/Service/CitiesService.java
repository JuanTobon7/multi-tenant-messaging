package multi_tenant_back.tenant_api.CitiesStates.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import multi_tenant_back.tenant_api.CitiesStates.model.CitiesModel;
import multi_tenant_back.tenant_api.CitiesStates.model.StateModel;
import multi_tenant_back.tenant_api.CitiesStates.repository.CitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class CitiesService {
    private final CitiesRepository citiesRepository;
    public List<CitiesModel> createCities(List<String> cities, StateModel state)throws Exception{
        if(cities.isEmpty()){
            throw new Exception("Not enough cities");
        }
        List<CitiesModel> citiesBank = cities.stream().map((item)-> {
                CitiesModel city = new CitiesModel();
                city.setName(item);
                city.setState(state);
                return city;
            }).toList();
        return citiesRepository.saveAll(citiesBank);
    }
    public CitiesModel getSomeCitie() throws Exception{
        List<CitiesModel> cities = citiesRepository.findAll();
        if(cities.isEmpty()){
            throw new Exception("Not yet registered cities");
        }
        Random random = new Random();
        return cities.get(random.nextInt(cities.size()));
    }
}
