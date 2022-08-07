package boramarket.boramarketapi.config.session.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@RedisHash(value = "user")
public class UserSession {

    @Id
    private String id;
    private String userId;
    private String userPw;
    private String userName;

    @Builder
    public  UserSession(String id,String userId,String userPw,String userName){
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
    }
}
