package boramarket.boramarketapi.web;

import boramarket.boramarketapi.config.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RequiredArgsConstructor
@Controller
@Slf4j
public class viewController {


    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){

        if(userDetails != null)
            return "redirect:/user/exists";

        return "index";
    }


    @GetMapping(value = "/user/exists")

    public @ResponseBody HashMap<String,String> admin(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                      HttpServletResponse response,
                                                      HttpServletRequest request){
        HashMap<String, String> map = new HashMap<>();
        map.put("Id",userDetails.getId());
        map.put("userId",userDetails.getUserId());
        response.setCharacterEncoding("UTF-8");

        log.info("session ={}",request.getSession().getId());

        return map;
    }
}
