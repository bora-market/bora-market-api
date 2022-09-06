package boramarket.boramarketapi.domain.entity.user;

import boramarket.boramarketapi.config.security.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.management.relation.Role;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "user")
@Entity
@NoArgsConstructor
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @Column
    private String userNickName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Builder
    public User(String userId, String userPw, String userName,String userNickName ,UserRole role){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userNickName = userNickName;
        this.role = role;
    }
}
