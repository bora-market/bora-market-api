package boramarket.boramarketapi.domain.entity.category;

import boramarket.boramarketapi.domain.entity.goods.Goods;
import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    @Column
    private CategoryClass categoryClass;

    @Column
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_parent_lev")
    private Category categoryParentLev;

    @Column
    private int categoryDetailLev;
}
