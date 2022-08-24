package boramarket.boramarketapi.service;

import boramarket.boramarketapi.domain.entity.comment.CommentRepository;
import boramarket.boramarketapi.domain.entity.post.Post;
import boramarket.boramarketapi.domain.entity.post.PostRepository;
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

        return posts.stream().map(PostResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponseDTO findById(Long id){

        Post post = postRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return PostResponseDTO.builder()
                .post(post)
                .build();
    }

}
