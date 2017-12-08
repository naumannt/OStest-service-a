package service;

/**
 * Created by torstennaumann on 06.11.17.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${serviceb.discovery.uri:localhost}")
    private String URI;

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    @RequestMapping("/datafromb")
    Data getDataFromB() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URI + "/data",Data.class);
    }
}