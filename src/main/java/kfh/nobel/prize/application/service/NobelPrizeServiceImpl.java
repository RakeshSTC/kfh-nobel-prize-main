package kfh.nobel.prize.application.service;

import kfh.nobel.prize.application.model.Laureate;
import kfh.nobel.prize.application.model.Prizes;
import kfh.nobel.prize.application.repository.LaurateRepository;
import kfh.nobel.prize.application.repository.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NobelPrizeServiceImpl implements NobelPrizeService {

    @Autowired
    private PrizeRepository prizeRepository;
    
    @Autowired
    private LaurateRepository laurateRepository;

    public List<Prizes> findAll(){
    	return prizeRepository.findAll();
    }
    
    public Prizes save(Prizes prize) {
    	return prizeRepository.save(prize);
    }
    
    public Iterable<Prizes> saveAll(List<Prizes> prizes){
        return prizeRepository.saveAll(prizes);
    }
    
	public List<Prizes> findByYear(String year){
		return prizeRepository.findByYear(year);
	}
	public List<Prizes> findByCategory(String category){
		return prizeRepository.findByCategory(category);
	}
	   
	public List<Prizes> findAllByOrderByYearAsc(){
		return prizeRepository.findAllByOrderByYearAsc();
	}
	public List<Prizes> findAllByOrderByYearDesc(){
		return prizeRepository.findAllByOrderByYearDesc();
	}
	
	public List<Laureate> findBysurname(String laurate){
		return laurateRepository.findBysurname(laurate);
	}
	   
	public List<Laureate> findAllByOrderBySurnameAsc(){
		return laurateRepository.findAllByOrderBySurnameAsc();
	}
	public List<Laureate> findAllByOrderBySurnameDesc(){
		return laurateRepository.findAllByOrderBySurnameDesc();
	}
	
	public List<Prizes> findByCategoryOrYearOrLaureates_Firstname(String name, String category, String year){
		List<Prizes> prizes = prizeRepository.findByCategoryOrYearOrLaureates_Firstname(name, category, year);
		//to do
		//Play after single JPA call and perform necessary sorting based on name/year and
		//number of share per prize, using stream API..		
		return prizes;
	}

}
