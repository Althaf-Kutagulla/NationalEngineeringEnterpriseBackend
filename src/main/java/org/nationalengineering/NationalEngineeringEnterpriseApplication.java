package org.nationalengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class NationalEngineeringEnterpriseApplication {

    public static void main(String[] args) {
        SpringApplication.run(NationalEngineeringEnterpriseApplication.class, args);
    }
}
