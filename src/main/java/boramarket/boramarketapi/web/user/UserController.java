package boramarket.boramarketapi.web.user;

import boramarket.boramarketapi.config.session.SessionAttribute;
import boramarket.boramarketapi.config.session.vo.UserVO;
import boramarket.boramarketapi.domain.service.UserService;
import boramarket.boramarketapi.web.user.dto.UserRequestDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    private HttpStatus jsonLogin(@RequestBody UserVO userVO, HttpServletRequest request){

        if(userService.login(userVO.getUserId(), userVO.getUserPw())){
            HttpSession session = request.getSession(false);
            session.setAttribute(SessionAttribute.attribute,userVO);
            log.info("session = {}",session.getAttribute(SessionAttribute.attribute));
            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private HttpStatus formLogin(UserVO userVO, HttpServletRequest request){
        if(userService.login(userVO.getUserId(), userVO.getUserPw())){
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttribute.attribute,userVO);

            session.getAttributeNames().asIterator()
                    .forEachRemaining(name -> log.info("session name={}, value={}",
                            name, session.getAttribute(name)));
            log.info("sessionId={}", session.getId());
            log.info("maxInactiveInterval={}", session.getMaxInactiveInterval());
            log.info("creationTime={}", new Date(session.getCreationTime()));
            log.info("lastAccessedTime={}", new
                    Date(session.getLastAccessedTime()));
            log.info("isNew={}", session.isNew());
            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }

    @GetMapping("/info")
    public String getUserinfo(@org.springframework.web.bind.annotation.SessionAttribute(name = SessionAttribute.attribute) UserVO userVO){
        return userVO.getUserId();
    }

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
}
