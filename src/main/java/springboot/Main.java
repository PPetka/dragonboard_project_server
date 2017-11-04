package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Main {


    public static void main(String args[]) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String mainSite() {
        return "server is running";
    }

}


