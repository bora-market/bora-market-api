package boramarket.boramarketapi.domain.entity.goods;

import boramarket.boramarketapi.domain.entity.category.Category;
import boramarket.boramarketapi.domain.entity.store.Store;
import boramarket.boramarketapi.domain.entity.country.Country;
import boramarket.boramarketapi.domain.entity.size.Size;
import boramarket.boramarketapi.domain.entity.tour.Tour;
import boramarket.boramarketapi.domain.entity.user.BaseTimeEntity;
import boramarket.boramarketapi.web.goods.dto.GoodsResponseDto;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Table(name = "goods")
@Entity
public class Goods{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long goodsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",insertable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private String goodsName;

    @Column
    private String goodsColor;

    @Column(nullable = false)
    private int goodsPrice;


    public GoodsResponseDto toDto(){
        return GoodsResponseDto.builder()
                .id(goodsId)
                .goodsName(goodsName)
                .store(store.getStoreName())
                .releaseDate(releaseDate)
                .country(country.getCountryName())
                .categoryBig(category.getCategoryParentLev().getCategoryName())
                .categorySmall(category.getCategoryName())
                .color(goodsColor)
                .tour(tour.getTourName())
                .price(goodsPrice)
                .build();
    }
}
