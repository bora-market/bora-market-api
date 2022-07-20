package boramarket.boramarketapi.domain.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByUserId(String userId);
}
