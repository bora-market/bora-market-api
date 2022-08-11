package boramarket.boramarketapi.config.database;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@PropertySource(value = "file:${user.home}/documents/config/application-database.properties",ignoreResourceNotFound = true)
@RequiredArgsConstructor
@Configuration
public class databasePropertySource {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    
    @Value("spring.datasource.url")
    private String url;

    @Value("spring.datasource.username")
    private String username;

    @Value("spring.datasource.password")
    private String password;

}