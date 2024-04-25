package staff.Api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseBodyResponse<T> {
    private String httpStatus;
    private String message;
    private T response;
}
