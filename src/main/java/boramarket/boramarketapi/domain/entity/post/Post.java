package boramarket.boramarketapi.domain.entity.post;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String post_author;

    @Column
    private String post_title;

    @Column
    private String post_content;

}
