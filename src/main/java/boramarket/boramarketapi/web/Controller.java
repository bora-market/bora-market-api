package boramarket.boramarketapi.web;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @GetMapping("/ao")
    public String ao(){

        return "index";
    }

    @GetMapping("/admin")
    public String admin(){

        return "index";
    }
}
