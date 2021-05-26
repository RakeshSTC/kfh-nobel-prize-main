package kfh.nobel.prize.application.service;

import java.util.List;

import kfh.nobel.prize.application.model.Laureate;
import kfh.nobel.prize.application.model.Prizes;

public interface NobelPrizeService {
	   List<Prizes> findAll();
	
	   Prizes save(Prizes prize);
	   Iterable<Prizes> saveAll(List<Prizes> prizes);
	   List<Prizes> findByYear(String year);
	   List<Prizes> findByCategory(String category);
	   List<Prizes> findByCategoryOrYearOrLaureates_Firstname(String name, String category, String year);
	   
	   List<Prizes> findAllByOrderByYearAsc();
	   List<Prizes> findAllByOrderByYearDesc();
	   
	   List<Laureate> findBysurname(String laurate);
		   
	   List<Laureate> findAllByOrderBySurnameAsc();
	   List<Laureate> findAllByOrderBySurnameDesc();
}
