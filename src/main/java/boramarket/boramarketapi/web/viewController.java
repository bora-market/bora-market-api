package boramarket.boramarketapi.web;

import boramarket.boramarketapi.config.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class viewController {

    @GetMapping("/")
    public String index(
                        Model model){

        return "index";
    }

    @GetMapping("/ao")
    public String ao(){

        return "index";
    }

    @GetMapping("/user/exists")
    public String admin(@AuthenticationPrincipal UserDetailsImpl userDetails,
                        Model model){
        model.addAttribute("name",userDetails.getUserId());
        return "exists";
    }
}
