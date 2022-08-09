package boramarket.boramarketapi.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic().and().csrf().disable()
                .formLogin()
                .usernameParameter("userId")
                .passwordParameter("userPw")
                .loginProcessingUrl("/api/user/login")
                .defaultSuccessUrl("/api/user/info")
                .and()
                .authorizeRequests()
                .antMatchers("/index","/api/user/login/**","/swagger-ui/**","/swagger-resources/**","/v3/api-docs/**", "/user/register","/forgotPassword","/delete/**").permitAll()
                .antMatchers("/ao").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/zz");

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
