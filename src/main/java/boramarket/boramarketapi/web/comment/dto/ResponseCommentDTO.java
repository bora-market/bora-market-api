package boramarket.boramarketapi.web.comment.dto;

import boramarket.boramarketapi.domain.entity.comment.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResponseCommentDTO {

    private String commentAuthor;

    private String commentContent;

    private List<ResponseCommentDTO> childComments;

    @Builder
    public ResponseCommentDTO(Comment comment) {
        this.commentAuthor = comment.getUser().getUserName();
        this.commentContent = comment.getContent();
        this.childComments = comment.getChildComments().stream().map(ResponseCommentDTO::new).collect(Collectors.toList());
    }
}
