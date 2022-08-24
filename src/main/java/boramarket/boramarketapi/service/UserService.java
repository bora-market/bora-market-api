package boramarket.boramarketapi.service;

import boramarket.boramarketapi.config.security.UserRole;
import boramarket.boramarketapi.domain.entity.user.User;
import boramarket.boramarketapi.domain.entity.user.UserRepository;
import boramarket.boramarketapi.web.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Boolean signUp(UserRequestDto requestDto){

        if(userRepository.existsByUserId(requestDto.getUserId()))
            return false;

        log.info("role = {}", UserRole.USER);
        userRepository.save(requestDto.toEntity(passwordEncoder.encode(requestDto.getUserPw())));
        return true;
    }

    @Transactional(readOnly = true)
    public boolean login(String id, String pwd){
        User user = userRepository.findByUserId(id).orElse(null);

        if(user == null || !passwordEncoder.matches(pwd,user.getUserPw())){
            return false;
        }

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(id,pwd);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("login = {}",SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return true;
    }
}
