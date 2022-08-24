package boramarket.boramarketapi.service;

import boramarket.boramarketapi.domain.entity.comment.Comment;
import boramarket.boramarketapi.domain.entity.comment.CommentRepository;
import boramarket.boramarketapi.web.comment.dto.ResponseCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<ResponseCommentDTO> findAll(){
        List<Comment> comments = commentRepository.findAllByCommentDepthOne();

        return comments.stream().map(ResponseCommentDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResponseCommentDTO findCommentById(Long id){
        Comment comments = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return ResponseCommentDTO.builder()
                .comment(comments)
                .build();
    }
}
