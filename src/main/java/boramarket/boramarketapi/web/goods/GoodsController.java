package boramarket.boramarketapi.web.goods;

import boramarket.boramarketapi.domain.service.GoodsService;
import boramarket.boramarketapi.web.goods.dto.GoodsResponseDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "굿즈 정보")
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping("/goods")
    private ResponseEntity<List<GoodsResponseDto>> getGoods(){

        return new ResponseEntity<>(goodsService.getGoods(), HttpStatus.OK);
    }

    @GetMapping("/goods/{categoryName}")
    private ResponseEntity<List<GoodsResponseDto>> getGoodsByCategoryName(@PathVariable(value = "categoryName") String categoryName){

        return new ResponseEntity<>(goodsService.getGoodsByCategoryName(categoryName), HttpStatus.OK);
    }
}
