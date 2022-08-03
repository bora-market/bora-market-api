package boramarket.boramarketapi.config.session.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserVO {

    private final String userId;
    private final String userPw;
    private final String userName;

}
