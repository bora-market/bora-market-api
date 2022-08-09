package boramarket.boramarketapi.web.user.dto;

import boramarket.boramarketapi.config.security.UserRole;
import boramarket.boramarketapi.domain.entity.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Getter
public class UserRequestDto {


    private final String userId;
    private final String userPw;
    private final String userName;

    public User toEntity(String encryptedUserPw){
        return User.builder()
                .userId(userId)
                .userPw(encryptedUserPw)
                .userName(userName)
                .role(UserRole.USER)
                .build();
    }
}
