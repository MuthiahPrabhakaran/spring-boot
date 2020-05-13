package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@DataJpaTest 
@RunWith(SpringRunner.class) 
public class LocationRepositoryTest {

	@Autowired
	public LocationRepository locationRepository;
	
	@Test
	public void testFindAll() {
		List<Location> locations = locationRepository.findAll();
		assertNotNull(locations);
	}
}
