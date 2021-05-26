package kfh.nobel.prize.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kfh.nobel.prize.application.model.Laureate;

@Repository
public interface LaurateRepository extends JpaRepository<Laureate, Long>{
	List<Laureate> findBysurname(String laurate);
	   
	List<Laureate> findAllByOrderBySurnameAsc();
	List<Laureate> findAllByOrderBySurnameDesc();
}
