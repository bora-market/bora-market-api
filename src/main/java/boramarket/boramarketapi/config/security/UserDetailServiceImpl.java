package boramarket.boramarketapi.config.security;
import boramarket.boramarketapi.domain.entity.user.User;
import boramarket.boramarketapi.domain.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId).orElseThrow(()-> new UsernameNotFoundException("Cannot found user : "+userId));

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(user.getRole().getRole()));

        return UserDetailsImpl.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .userPw(user.getUserPw())
                .userName(user.getUserName())
                .role(user.getRole())
                .authorities(list)
                .build();
    }

}