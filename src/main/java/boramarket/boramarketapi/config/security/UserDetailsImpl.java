package boramarket.boramarketapi.config.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@RedisHash(value = "user_session")
public class UserDetailsImpl implements UserDetails {

    @Id
    private String id;
    private String userId;
    private String userPw;
    private String userName;
    private UserRole role;
    private Collection<? extends GrantedAuthority> authorities;

    @Builder
    public UserDetailsImpl(String id, String userId, String userPw, String userName, UserRole role, List<GrantedAuthority> authorities) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.role = role;
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.userPw;
    }

    public String getUserId(){
        return this.userId;
    }
    public String getId() {return this.id;}

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}