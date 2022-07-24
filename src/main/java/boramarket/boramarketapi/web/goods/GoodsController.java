package boramarket.boramarketapi.web.goods;

import boramarket.boramarketapi.domain.service.GoodsService;
import boramarket.boramarketapi.web.goods.dto.GoodsRequestDto;
import boramarket.boramarketapi.web.goods.dto.GoodsResponseDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags = "굿즈 정보")
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping("/goods")
    private ResponseEntity<List<GoodsResponseDto>> getGoods(){

        return new ResponseEntity<>(goodsService.getGoods(), HttpStatus.OK);
    }

}
