package web.adminlicense.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "web.adminlicense.*")
@EnableJpaRepositories(basePackages = "web.adminlicense.repositories")
@EntityScan(basePackages = "web.adminlicense.models")
@ImportResource("classpath:spring-context.xml")
public class AdminLicenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminLicenseApplication.class, args);
    }
}
