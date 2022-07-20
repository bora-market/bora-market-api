package boramarket.boramarketapi.web.user;

import boramarket.boramarketapi.domain.service.UserService;
import boramarket.boramarketapi.web.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    private ResponseEntity<Boolean> signUp(@RequestBody UserRequestDto requestDto){

        if(userService.signUp(requestDto))
            return new ResponseEntity<>(true, HttpStatus.OK);

        return new ResponseEntity<>(false,HttpStatus.OK);
    }

}
