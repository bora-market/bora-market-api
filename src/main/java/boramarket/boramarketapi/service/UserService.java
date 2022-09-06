package boramarket.boramarketapi.service;

import boramarket.boramarketapi.config.Exception.PasswordNotMatchedException;
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

import java.util.NoSuchElementException;

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
    public void login(String id, String pwd){
        User user = userRepository.findByUserId(id).orElseThrow(NoSuchElementException::new);

        if(!passwordEncoder.matches(pwd,user.getUserPw())){
            throw new PasswordNotMatchedException("비밀번호 불일치");
        }

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(id,pwd);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("login = {}",SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
    }
}
