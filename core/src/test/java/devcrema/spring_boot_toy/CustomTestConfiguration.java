package devcrema.spring_boot_toy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ComponentScan(basePackages = "devcrema.spring_boot_toy")
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class CustomTestConfiguration {
}