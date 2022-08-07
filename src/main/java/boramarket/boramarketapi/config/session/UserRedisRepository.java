package boramarket.boramarketapi.config.session;

import boramarket.boramarketapi.config.session.vo.UserSession;
import org.springframework.data.repository.CrudRepository;


public interface UserRedisRepository extends CrudRepository<UserSession,String> {


}
