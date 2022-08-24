package boramarket.boramarketapi.domain.entity.post;

import boramarket.boramarketapi.domain.entity.user.BaseTimeEntity;
import boramarket.boramarketapi.domain.entity.user.User;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "post_author")
    @ManyToOne
    private User postAuthor;

    @Column
    private String postTitle;

    @Column
    private String postContent;

}
