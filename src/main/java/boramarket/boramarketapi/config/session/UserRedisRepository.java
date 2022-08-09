package boramarket.boramarketapi.config.session;

import boramarket.boramarketapi.config.security.UserDetailsImpl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRedisRepository extends CrudRepository<UserDetailsImpl,String> {


    Optional<UserDetailsImpl> findByUserId(String userId);
}
