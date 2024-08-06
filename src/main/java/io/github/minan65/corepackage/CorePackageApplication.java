package io.github.minan65.corepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"io.github.minan65.corepackage"})
@ComponentScan(basePackages ={"io.github.minan65.corepackage.security"})
public class CorePackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorePackageApplication.class, args);
	}

}
