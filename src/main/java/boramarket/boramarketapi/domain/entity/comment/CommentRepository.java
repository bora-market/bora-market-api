package boramarket.boramarketapi.domain.entity.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT c FROM Comment c WHERE c.commentDepth = 1")
    List<Comment> findAllByCommentDepthOne(@Param("id") Long id);
}
