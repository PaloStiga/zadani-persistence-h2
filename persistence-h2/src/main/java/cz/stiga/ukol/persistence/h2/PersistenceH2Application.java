package cz.stiga.ukol.persistence.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersistenceH2Application {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceH2Application.class, args);
    }

}
