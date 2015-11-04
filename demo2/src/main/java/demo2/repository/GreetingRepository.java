package demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo2.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long>{

	
}
