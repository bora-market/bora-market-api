package boramarket.boramarketapi.web.user.dto;

import boramarket.boramarketapi.domain.entity.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRequestDto {

    private final String userId;
    private final String userPw;
    private final String userName;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .build();
    }
}
