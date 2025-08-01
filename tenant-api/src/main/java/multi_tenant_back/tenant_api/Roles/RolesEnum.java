package multi_tenant_back.tenant_api.Roles;

import lombok.Getter;

@Getter
public enum RolesEnum {
    CLIENT("Client"),
    EMPLOYEE("Employee"),
    ADMIN("Admin"),
    ADMIN_APP("Admin_App");

    private final String value;

    RolesEnum(String value) {
        this.value = value;
    }

    // Opcional: para mapear de String a Enum
    public static RolesEnum fromValue(String value) {
        for (RolesEnum role : values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + value);
    }
}