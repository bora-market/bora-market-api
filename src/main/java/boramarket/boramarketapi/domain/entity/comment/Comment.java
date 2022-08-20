package boramarket.boramarketapi.domain.entity.comment;

import boramarket.boramarketapi.domain.entity.post.Post;
import boramarket.boramarketapi.domain.entity.user.User;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @JoinColumn(name = "comment_author")
    @ManyToOne(fetch = FetchType.LAZY)
    private User commentAuthor;

    @Column
    private String commentContent;

    @JoinColumn(name = "parent_post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post parentPost;

    @JoinColumn(name = "parent_comment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parentComment;

}
