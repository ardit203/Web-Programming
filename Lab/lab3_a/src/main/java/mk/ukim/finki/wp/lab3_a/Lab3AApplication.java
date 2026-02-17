package mk.ukim.finki.wp.lab3_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab3AApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3AApplication.class, args);
    }

}
