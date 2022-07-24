package boramarket.boramarketapi.domain.service;

import boramarket.boramarketapi.domain.entity.category.CategoryRepository;
import boramarket.boramarketapi.domain.entity.goods.Goods;
import boramarket.boramarketapi.domain.entity.goods.GoodsRepository;
import boramarket.boramarketapi.web.goods.dto.GoodsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoodsService {
    private final GoodsRepository goodsRepository ;

    @Transactional(readOnly = true)
    public List<GoodsResponseDto> getGoods(){
        List<Goods> goods = goodsRepository.findAll();

        return goods.stream()
                .map(Goods :: toDto)
                .collect(Collectors.toList());

                /*
        return GoodsResponseDto.builder()
                .id(goods.getGoodsId())
                .goodsName(goods.getGoodsName())
                .store(goods.getStore().getStoreName())
                .releaseDate(goods.getReleaseDate())
                .country(goods.getCountry().getCountryName())
                .categoryBig(goods.getCategory().getCategoryParentLev().getCategoryName())
                .categorySmall(goods.getCategory().getCategoryName())
                .color(goods.getGoodsColor())
                .tour(goods.getTour().getTourName())
                .price(goods.getGoodsPrice())
                .build();
                 */
    }

}
