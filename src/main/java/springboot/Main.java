package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Przemyslaw Petka on 10/19/2017.
 */

@RestController
@SpringBootApplication
public class Main {

    public static void main(String args[]) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        System.out.println(subtitle);
    }

    @GetMapping("/")
    public String mainWebSite() {
        return homeHtml;
    }

    public static String subtitle =
            "                                          _                _             _ \n" +
                    " ___   ___  _ __ __   __ ___  _ __   ___ | |_  __ _  _ __ | |_  ___   __| |\n" +
                    "/ __| / _ \\| '__|\\ \\ / // _ \\| '__| / __|| __|/ _` || '__|| __|/ _ \\ / _` |\n" +
                    "\\__ \\|  __/| |    \\ V /|  __/| |    \\__ \\| |_| (_| || |   | |_|  __/| (_| |\n" +
                    "|___/ \\___||_|     \\_/  \\___||_|    |___/ \\__|\\__,_||_|    \\__|\\___| \\__,_|\n" +
                    "                                                                           ";

    public static String homeHtml = "<!DOCTYPE html>" +
            "<html>" +
            "<body>" +
            "<pre>" +
            subtitle +
            "</pre>" +
            "</body>" +
            "</html>";

}