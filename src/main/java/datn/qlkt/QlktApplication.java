package datn.qlkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QlktApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlktApplication.class, args);
	}

}
