package multi_tenant_back.tenant_api.Roles;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesService {
    private final RolesRepository rolesRepository;
    public List<RolesModel> createRol(List<String> rolesName) throws InvalidParameterException{
        if(!rolesRepository.findAll().isEmpty()){
            throw new InvalidParameterException("Roles already exist");
        }
        if(rolesName.isEmpty()){
            throw new InvalidParameterException("Not enough roles names");
        }
        List<RolesModel> roles = rolesName.stream().map(item->{
            RolesModel role = new RolesModel();
            role.setName(item);
            return role;
        }).toList();

        return rolesRepository.saveAll(roles);
    }
}
