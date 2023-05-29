package com.example.projecthubserver;
import com.example.projecthubserver.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(CorsConfig.class)
@SpringBootApplication
public class ProjectHubServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectHubServerApplication.class, args);
	}
}
