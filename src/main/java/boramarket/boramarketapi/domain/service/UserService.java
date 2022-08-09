package boramarket.boramarketapi.domain.service;

import boramarket.boramarketapi.config.security.UserRole;
import boramarket.boramarketapi.domain.entity.user.User;
import boramarket.boramarketapi.domain.entity.user.UserRepository;
import boramarket.boramarketapi.web.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;

    @Transactional
    public Boolean signUp(UserRequestDto requestDto){

        if(userRepository.existsByUserId(requestDto.getUserId()))
            return false;

        log.info("role = {}", UserRole.USER);
        userRepository.save(requestDto.toEntity(passwordEncoder.encode(requestDto.getUserPw())));
        return true;
    }

    @Transactional(readOnly = true)
    public UUID login(String id, String pwd){
        User user = userRepository.findByUserId(id).orElse(null);

        if(user == null || !passwordEncoder.matches(pwd,user.getUserPw())){
            return null;
        }

        UUID uuid = UUID.randomUUID();
        return uuid;
    }
}
