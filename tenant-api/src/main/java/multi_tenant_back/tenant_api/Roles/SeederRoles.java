package multi_tenant_back.tenant_api.Roles;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SeederRoles {
    private final RolesService rolesService;

    @PostConstruct
    public void seedRoles() {
        try{
            List<String> rolesNames = Arrays.stream(RolesEnum.values()).map(Enum::name).toList();
            List<RolesModel> roles = rolesService.createRol(rolesNames);
            System.out.println("Roles created " + roles.size() + " roles");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
