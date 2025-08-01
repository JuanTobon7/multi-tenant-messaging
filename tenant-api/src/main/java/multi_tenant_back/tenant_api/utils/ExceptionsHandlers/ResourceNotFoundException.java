package multi_tenant_back.tenant_api.utils.ExceptionsHandlers;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
