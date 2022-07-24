package boramarket.boramarketapi.domain.entity.size;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;

    @Column(nullable = false)
    private String sizeName;
}
