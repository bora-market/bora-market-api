package boramarket.boramarketapi.web.goods.dto;

import boramarket.boramarketapi.domain.entity.category.CategoryClass;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class GoodsRequestDto {

    private final int id;
    private final String country;
    private final String store;
    private final LocalDate releaseDate;
    private final String categoryBig;
    private final String categorySmall;
    private final String tour;
    private final String goodsName;
    private final String color;
    private final int price;

}
