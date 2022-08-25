package boramarket.boramarketapi.web.user;

import boramarket.boramarketapi.config.security.UserDetailsImpl;
import boramarket.boramarketapi.service.UserService;
import boramarket.boramarketapi.web.user.dto.UserRequestDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "유저")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    private ResponseEntity<Boolean> signUp(@RequestBody UserRequestDto requestDto){

        if(userService.signUp(requestDto))
            return new ResponseEntity<>(true, HttpStatus.OK);

        return new ResponseEntity<>(false,HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private ResponseEntity<String> formLogin(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestParam("userId") String userId,
            @RequestParam("userPw") String userPw,
            HttpServletResponse response){

        if(userDetails != null){

            return new ResponseEntity<>("FAIL 이미 로그인 되어 있습니다",HttpStatus.OK);
        }

        if(userService.login(userId, userPw)){
            return new ResponseEntity<>("OK 로그인 성공했습니다",HttpStatus.OK);
        }

        return new ResponseEntity<>("FAIL 로그인 실패하였습니다",HttpStatus.OK);
    }

    @GetMapping("/info")
    public String getUserinfo(@AuthenticationPrincipal UserDetailsImpl userDetails){

        return userDetails.getUserId();

    }
    /*
    @GetMapping("/logout")
    public HttpStatus logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        try {
            log.info(session.getId());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return HttpStatus.OK;
    }
     */
}
