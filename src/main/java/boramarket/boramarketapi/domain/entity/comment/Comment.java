package boramarket.boramarketapi.domain.entity.comment;

import boramarket.boramarketapi.domain.entity.post.Post;
import boramarket.boramarketapi.domain.entity.user.User;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "comment")

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "comment_Author")
    private User user;

    @NotFound(action=NotFoundAction.IGNORE)
    @Column(name = "comment_content")
    private String content;

    @ManyToOne
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "parent_post_id")
    private Post post;

    @ManyToOne
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @Column(name = "comment_depth")
    private int commentDepth;

    @NotFound(action=NotFoundAction.IGNORE)
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "parentComment")
    private List<Comment> childComments;
}
