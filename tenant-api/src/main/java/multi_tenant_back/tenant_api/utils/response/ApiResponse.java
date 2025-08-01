package multi_tenant_back.tenant_api.utils.response;

public record ApiResponse<T>(ApiSummary status, String message, T data) {

    public static <T> ApiResponse<T> success(ApiMessages message, T data) {
        return new ApiResponse<>(ApiSummary.SUCCESS, message.getMessage(), data);
    }

    public static <T> ApiResponse<T> error(ApiMessages message, T data) {
        return new ApiResponse<>(ApiSummary.ERROR, message.getMessage(), data);
    }

    public static <T> ApiResponse<T> warning(ApiMessages message, T data) {
        return new ApiResponse<>(ApiSummary.WARNING, message.getMessage(), data);
    }

    public static <T> ApiResponse<T> success(ApiMessages message) {
        return new ApiResponse<>(ApiSummary.SUCCESS, message.getMessage(), null);
    }

    // etc...
}
