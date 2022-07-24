package boramarket.boramarketapi.domain.service;

import boramarket.boramarketapi.domain.entity.category.Category;
import boramarket.boramarketapi.domain.entity.category.CategoryRepository;
import boramarket.boramarketapi.domain.entity.goods.Goods;
import boramarket.boramarketapi.domain.entity.goods.GoodsRepository;
import boramarket.boramarketapi.web.goods.dto.GoodsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GoodsService {
    private final GoodsRepository goodsRepository ;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<GoodsResponseDto> getGoods(){
        List<Goods> goods = goodsRepository.findAll();

        return goodsEntityToDTO(goods);
    }

    @Transactional(readOnly = true)
    public List<GoodsResponseDto> getGoodsByCategoryName(String categoryName){
        Category category = categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(IllegalArgumentException::new);

        List<Goods> goods = category.getGoods();

        return goodsEntityToDTO(goods);
    }

    private List<GoodsResponseDto> goodsEntityToDTO(List<Goods> goodsList){
        return goodsList.stream()
                .map(Goods :: toDto)
                .collect(Collectors.toList());
    }

}
