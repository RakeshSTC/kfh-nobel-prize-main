package kfh.nobel.prize.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kfh.nobel.prize.application.model.Prizes;
import kfh.nobel.prize.application.service.NobelPrizeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Application {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(NobelPrizeService nobelPrizeService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Prizes>> typeReference = new TypeReference<List<Prizes>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/prize.json");
			try {
				List<Prizes> prizes = mapper.readValue(inputStream,typeReference);
				nobelPrizeService.saveAll(prizes);
				System.out.println("Prizes Saved!");
			} catch (IOException e){
				System.out.println("Unable to Prizes users: " + e.getMessage());
			}
		};
	}
}
