package boramarket.boramarketapi.domain.entity.store;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Store {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Long storeId;
    private String storeName;

}
