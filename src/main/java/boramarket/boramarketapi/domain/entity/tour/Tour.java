package boramarket.boramarketapi.domain.entity.tour;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourId;

    @Column(nullable = false)
    private String tourName;
}
