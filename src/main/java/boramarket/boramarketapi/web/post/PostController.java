package boramarket.boramarketapi.web.post;

import boramarket.boramarketapi.config.security.UserDetailsImpl;
import boramarket.boramarketapi.service.PostService;
import boramarket.boramarketapi.web.post.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    private List<PostResponseDTO> getPosts(){

        return postService.getPosts();
    }

    @GetMapping("/{id}")
    private PostResponseDTO getPost(@PathVariable Long id){
            return postService.findById(id);
    }


    @PostMapping("/")
    private ResponseEntity<HttpStatus> posting(@AuthenticationPrincipal UserDetailsImpl userDetails){


        postService.posting(userDetails.getId());

        return new ResponseEntity<>(HttpStatus.CONTINUE);
    }


}
