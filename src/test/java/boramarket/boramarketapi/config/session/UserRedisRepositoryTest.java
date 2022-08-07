package boramarket.boramarketapi.config.session;

import boramarket.boramarketapi.config.session.vo.UserSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRedisRepositoryTest {

    @Autowired
    private UserRedisRepository redisRepository;

    @Test
    void test(){
        //given
        UUID uuid = UUID.randomUUID();
        UserSession session = new UserSession(uuid.toString(),"test2","123123","userName");
        //when
        redisRepository.save(session);

        //then
        UserSession session1 = redisRepository.findById(uuid.toString()).orElseThrow(IllegalAccessError::new);
        Assertions.assertThat(session1.getUserId()).isEqualTo("test2");
    }
}