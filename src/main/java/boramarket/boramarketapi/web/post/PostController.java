package boramarket.boramarketapi.web.post;

import boramarket.boramarketapi.service.PostService;
import boramarket.boramarketapi.web.post.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public List<PostResponseDTO> getPosts(){

        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPost(@PathVariable Long id){
            return postService.findById(id);
    }
}
