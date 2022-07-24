package boramarket.boramarketapi.web.goods.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
public class GoodsResponseDto {

    private final Long id;
    private final String country;
    private final String store;
    private final LocalDate releaseDate;
    private final String categoryBig;
    private final String categorySmall;
    private final String tour;
    private final String goodsName;
    private final String color;
    private final int price;

    @Builder
    public GoodsResponseDto(Long id, String country, String store, LocalDate releaseDate, String categoryBig, String categorySmall, String tour, String goodsName, String color, int price) {
        this.id = id;
        this.country = country;
        this.store = store;
        this.releaseDate = releaseDate;
        this.categoryBig = categoryBig;
        this.categorySmall = categorySmall;
        this.tour = tour;
        this.goodsName = goodsName;
        this.color = color;
        this.price = price;
    }
}
