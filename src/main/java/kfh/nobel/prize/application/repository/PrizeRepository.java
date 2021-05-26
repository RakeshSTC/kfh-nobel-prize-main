package kfh.nobel.prize.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kfh.nobel.prize.application.model.Prizes;

@Repository
public interface PrizeRepository extends JpaRepository<Prizes, Long>{
   List<Prizes> findByYear(String year);
   List<Prizes> findByCategory(String category);
   List<Prizes> findByCategoryOrYearOrLaureates_Firstname(String name, String category, String year);
   
   List<Prizes> findAllByOrderByYearAsc();
   List<Prizes> findAllByOrderByYearDesc();
}
