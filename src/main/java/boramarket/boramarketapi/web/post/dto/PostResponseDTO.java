package boramarket.boramarketapi.web.post.dto;

import boramarket.boramarketapi.domain.entity.post.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponseDTO {


    private Long id;

    private String postAuthor;

    private String postTitle;

    private String postContent;

    @Builder
    public PostResponseDTO(Post post){
        this.id = post.getId();
        this.postAuthor = post.getPostAuthor().getUserName();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
    }
}
