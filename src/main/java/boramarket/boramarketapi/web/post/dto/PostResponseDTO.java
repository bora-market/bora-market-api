package boramarket.boramarketapi.web.post.dto;

import boramarket.boramarketapi.domain.entity.post.Post;
import boramarket.boramarketapi.web.comment.dto.ResponseCommentDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PostResponseDTO {

    private Long postId;

    private String postAuthor;

    private String postTitle;

    private String postContent;

    @JsonProperty(value = "comments")
    private List<ResponseCommentDTO> comments;

    @Builder
    public PostResponseDTO(Post post,List<ResponseCommentDTO> comments){
        this.postId = post.getId();
        this.postAuthor = post.getPostAuthor().getUserName();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.comments = comments;
    }
}
