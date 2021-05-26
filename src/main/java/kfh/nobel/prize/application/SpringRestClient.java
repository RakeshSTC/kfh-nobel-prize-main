package kfh.nobel.prize.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import kfh.nobel.prize.application.model.Prizes;

public class SpringRestClient {

	private static final String GET_PRIZES_ENDPOINT_URL = "http://localhost:8080/api/prizes";
	private static final String UPDATE_PRIZES_ENDPOINT_URL = "http://localhost:8080/api/prizes/{id}";
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringRestClient springRestClient = new SpringRestClient();
		
		// Step3: get all employees
		springRestClient.getPrize();
		
		// Step4: Update employee with id = 1
		springRestClient.updatePrize();
		
	}

	private void getPrize() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_PRIZES_ENDPOINT_URL, HttpMethod.GET, entity,
				String.class);

		System.out.println(result);
	}

	private void updatePrize() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		//to do
		Prizes updatedPrize = new Prizes();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_PRIZES_ENDPOINT_URL, updatedPrize, params);
	}
}
