package kfh.nobel.prize.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kfh.nobel.prize.application.exception.ResourceNotFoundException;
import kfh.nobel.prize.application.model.Laureate;
import kfh.nobel.prize.application.model.Prizes;
import kfh.nobel.prize.application.service.NobelPrizeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class KFHController {
	@Autowired
	private NobelPrizeService prizeService;
	
	@GetMapping("/prizes/all")
	public List<Prizes> getAllEmployees() {
		return prizeService.findAll();
	}
	
	@GetMapping("/prizes/{order}")
	public List<Prizes> getPrizesByYear(@PathVariable(value = "order") String order) {
		if(order.equals("asc")) {
			return prizeService.findAllByOrderByYearAsc();
		} else {
			return prizeService.findAllByOrderByYearDesc();
		}
	}
	
	@GetMapping("/laureates/{order}")
	public List<Laureate> getPrizesByName(@PathVariable(value = "order") String order) {
		if(order.equals("asc")) {
			return prizeService.findAllByOrderBySurnameAsc();
		} else {
			return prizeService.findAllByOrderBySurnameDesc();
		}
	}

	@GetMapping("/prizes")
	public ResponseEntity<List<Prizes>> getPrizes(@RequestParam(name="name", required=false) String name,
			@RequestParam(name="category", required=false) String category,
			@RequestParam(name="year", required=false) String year)
			throws ResourceNotFoundException {
		List<Prizes> lstPrizes = new ArrayList<>();
		lstPrizes = prizeService.findByCategoryOrYearOrLaureates_Firstname(category, year, name);
		return ResponseEntity.ok().body(lstPrizes);
	}

	@PutMapping("/prizes")
	public ResponseEntity<Prizes> updatePrizes(@Valid @RequestBody Prizes prizeDetails) throws ResourceNotFoundException {
		final Prizes updatedPrize = prizeService.save(prizeDetails);
		return ResponseEntity.ok(updatedPrize);
	}

}
