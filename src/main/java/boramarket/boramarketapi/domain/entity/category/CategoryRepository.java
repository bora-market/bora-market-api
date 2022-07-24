package boramarket.boramarketapi.domain.entity.category;

import boramarket.boramarketapi.domain.entity.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
