package multi_tenant_back.tenant_api.utils.response;

import lombok.Getter;

@Getter
public enum ApiMessages {
    RESOURCE_FOUND("Recurso encontrado"),
    RESOURCE_NOT_FOUND("Recurso no encontrado"),
    RESOURCE_CREATED("Recurso creado exitosamente"),
    RESOURCE_UPDATED("Recurso actualizado"),
    RESOURCE_DELETED("Recurso eliminado"),
    BAD_REQUEST("Petición inválida"),
    INTERNAL_ERROR("Error interno del servidor"),
    VALIDATION_ERROR("Error de validación"),
    CONFLICT("Recurso duplicado");

    private final String message;

    ApiMessages(String message) {
        this.message = message;
    }

}
