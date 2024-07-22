package pedrodio.librarymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pedrodio.librarymanager")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
