package boramarket.boramarketapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BoraMarketApiApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BoraMarketApiApplication.class)
                .properties(
                        "spring.config.location=" +
                                "classpath:/application.properties" +
                                ", file:/etc/config/application-redis.properties" +
                                ", file:/etc/config/application-database.properties"
                )
                .run(args);

    }

}