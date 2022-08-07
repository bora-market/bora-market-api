package boramarket.boramarketapi.web.user.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
public class UserResponseDto {

    private UUID uuid;
    private HttpStatus status;

    @Builder
    public UserResponseDto(UUID uuid, HttpStatus status){
        this.uuid = uuid;
        this.status = status;
    }
}
