package boramarket.boramarketapi.domain.service;

import boramarket.boramarketapi.domain.entity.user.UserRepository;
import boramarket.boramarketapi.web.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Boolean signUp(UserRequestDto requestDto){

        if(userRepository.existsByUserId(requestDto.getUserId()))
            return false;

        userRepository.save(requestDto.toEntity(passwordEncoder.encode(requestDto.getUserPw())));
        return true;
    }
}
