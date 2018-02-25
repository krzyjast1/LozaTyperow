package pl.jastrzebskikrzysztof.lozatyperow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"pl.jastrzebskikrzysztof.lozatyperow"})
public class LozatyperowApplication {

	public static void main(String[] args) {
		SpringApplication.run(LozatyperowApplication.class, args);
	}
}
