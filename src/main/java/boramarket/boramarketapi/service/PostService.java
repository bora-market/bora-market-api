package boramarket.boramarketapi.service;

import boramarket.boramarketapi.domain.entity.comment.Comment;
import boramarket.boramarketapi.domain.entity.comment.CommentRepository;
import boramarket.boramarketapi.domain.entity.post.Post;
import boramarket.boramarketapi.domain.entity.post.PostRepository;
import boramarket.boramarketapi.web.comment.dto.ResponseCommentDTO;
import boramarket.boramarketapi.web.post.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<PostResponseDTO> getPosts(){

        List<Post> posts = postRepository.findAll();

        return posts.stream().map(i->toDTO(i,null)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponseDTO findById(Long id){

        Post post = postRepository.findById(id).orElseThrow(NoSuchElementException::new);
        List<Comment> comments = commentRepository.findAllByCommentDepthOne(post.getId());
        List<ResponseCommentDTO> responseCommentDTOs = comments.stream().map(ResponseCommentDTO::new).collect(Collectors.toList());
        return PostResponseDTO.builder()
                .post(post)
                .comments(responseCommentDTOs)
                .build();
    }

    @Transactional(readOnly = true)
    public List<ResponseCommentDTO> findAll(){
        List<Comment> comments = commentRepository.findAllByCommentDepthOne(2L);

        return comments.stream().map(ResponseCommentDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResponseCommentDTO findCommentById(Long id){
        Comment comments = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return ResponseCommentDTO.builder()
                .comment(comments)
                .build();
    }

    protected static PostResponseDTO toDTO(Post post, List<ResponseCommentDTO> commentDTOs){
        return PostResponseDTO.builder()
                .post(post)
                .comments(commentDTOs)
                .build();
    }

}
