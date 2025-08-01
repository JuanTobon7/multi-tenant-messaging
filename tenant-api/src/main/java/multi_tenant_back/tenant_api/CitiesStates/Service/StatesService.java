package multi_tenant_back.tenant_api.CitiesStates.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import multi_tenant_back.tenant_api.CitiesStates.model.StateModel;
import multi_tenant_back.tenant_api.CitiesStates.repository.StatesRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StatesService {
    private final StatesRepository statesRepository;
    public StateModel createStates(String stateName, Integer id)throws Exception{
        if(stateName.isEmpty() || id == null){
            throw new Exception("States is empty");
        }
        StateModel state = new StateModel();
        state.setName(stateName);
        state.setId(id);
        if(statesRepository.existsById(id)){
            throw new Exception("States already exists");
        }
        return this.statesRepository.save(state);
    }
}
