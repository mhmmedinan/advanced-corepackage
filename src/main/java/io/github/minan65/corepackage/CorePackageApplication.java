package io.github.minan65.corepackage;

import io.github.minan65.corepackage.abstractions.events.IntegrationEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.minan65.corepackage")
public class CorePackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorePackageApplication.class, args);
	}

}
