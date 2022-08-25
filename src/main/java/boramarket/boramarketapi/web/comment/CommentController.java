package boramarket.boramarketapi.web.comment;

import boramarket.boramarketapi.service.PostService;
import boramarket.boramarketapi.web.comment.dto.ResponseCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final PostService postService;

    @GetMapping("/")
    public List<ResponseCommentDTO> getComments(){

        return postService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseCommentDTO getComments(@PathVariable("id") Long id){

        return postService.findCommentById(id);
    }
}
