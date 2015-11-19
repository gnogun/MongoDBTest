package demo2.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo2.model.Greeting;
import demo2.repository.GreetingRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class GreetingServiceBean implements GreetingService{

	@Autowired
	private GreetingRepository greetingRepository;
	
	
//	private static Long nextId ;
//	private static Map<Long, Greeting> greetingMap;
//	
//	private static Greeting save(Greeting greeting){
//		if(greetingMap == null){
//			greetingMap = new HashMap<Long, Greeting> ();
//			nextId = new Long(1);
//		}
//		
//		if(greeting.getId() != null){
//			Greeting oldGreeting = greetingMap.get(greeting.getId());
//			if(oldGreeting == null)
//				return null;
//			greetingMap.remove(greeting.getId());
//			greetingMap.put(greeting.getId(), greeting);
//			return greeting;
//		}
//		
//		greeting.setId(nextId);
//		nextId +=1;
//		greetingMap.put(greeting.getId(), greeting);
//		return greeting;
//	}
//	
//	private static boolean remove(Long id){
//		Greeting deletedGreeting = greetingMap.remove(id);
//		if(deletedGreeting == null)
//			return false;
//		return true;
//	}
//	
//	
//	static {
//		Greeting g1 = new Greeting();
//		g1.setText("hello world");
//		save(g1);
//		
//		Greeting g2 = new Greeting();
//		g2.setText("hola mundo");
//		save(g2);
//		
//		
//	}
//	
	
	@Cacheable(value="testCache")
	@Override
	public Collection<Greeting> findAll() {
		// TODO Auto-generated method stub
		Collection<Greeting> greetings = greetingRepository.findAll();
		return greetings;
	}
	
	@Cacheable(value="testCache", key="#id")
	@Override
//	@Cacheable(value="greetings" ,key="#id")
	public Greeting findOne(Long id) {
		// TODO Auto-generated method stub
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;
	}

	@CacheEvict(value="testCache", allEntries=true)
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
//	@CachePut(value="greetings", key="#greeting.id" )
	public Greeting create(Greeting greeting) {
		// TODO Auto-generated method stub
		if(greeting.getId() != null){
			return null;
		}
		Greeting savedGreeting = greetingRepository.save(greeting);
		if(savedGreeting.getId() == 4L){
			throw new RuntimeException("Roll me back");
		}
		return savedGreeting;
	}
	
	@CacheEvict(value="testCache", allEntries=true)
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
//	@CachePut(value="greetings", key="#greeting.id")
	public Greeting update(Greeting greeting) {
		// TODO Auto-generated method stub
		Greeting greetingPersisted = findOne(greeting.getId());
		if(greetingPersisted == null){
			return null;
		}
		
		Greeting updatedGreeting = greetingRepository.save(greeting);
		return updatedGreeting;
	}
	
	@CacheEvict(value="testCache", allEntries=true)
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
//	@CacheEvict(value="greetings", key="#id" )
	public void delete(Long id) {
		// TODO Auto-generated method stub
		greetingRepository.delete(id);
	}

	@Override
	@CacheEvict(value="testCache", allEntries=true)
	public void evictCache() {
		// TODO Auto-generated method stub
		
	}
}
