package boramarket.boramarketapi.domain.entity.country;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Country {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long countryId;

    @Column(nullable = false)
    private String countryName;
}
