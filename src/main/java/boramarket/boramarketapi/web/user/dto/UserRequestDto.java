package boramarket.boramarketapi.web.user.dto;

import boramarket.boramarketapi.config.security.UserRole;
import boramarket.boramarketapi.domain.entity.user.User;
import lombok.Getter;
@Getter
public class UserRequestDto {


    private  String userId;
    private  String userPw;
    private  String userName;

    public UserRequestDto(){}

    public User toEntity(String encryptedUserPw){
        return User.builder()
                .userId(userId)
                .userPw(encryptedUserPw)
                .userName(userName)
                .role(UserRole.USER)
                .build();
    }
}
