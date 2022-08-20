package boramarket.boramarketapi.web;

import boramarket.boramarketapi.config.security.UserDetailsImpl;
import boramarket.boramarketapi.domain.entity.comment.Comment;
import boramarket.boramarketapi.domain.entity.comment.CommentRepository;
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

    private final CommentRepository commentRepository;

    @GetMapping("/")
    public String index(Model model){

        return "index";
    }

    @GetMapping("/ll")
    public @ResponseBody String ao(){
        Comment comment = commentRepository.findById(1L).orElseThrow(IllegalArgumentException::new);

        return comment.getCommentAuthor().getUserName();
    }

    @GetMapping(value = "/user/exists")
    public @ResponseBody HashMap<String,String> admin(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                      HttpServletResponse response,
                                                      HttpServletRequest request){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Id",userDetails.getId());
        map.put("userId",userDetails.getUserId());
        response.setCharacterEncoding("UTF-8");

        log.info("session ={}",request.getSession().getId());

        return map;
    }
}
