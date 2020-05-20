package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
public class LocationRepositoryTest {

	@Autowired
	public LocationRepository locationRepository;

	@Before
	public void initialize(){
		Location location = new Location();
		location.setCountry("Canada");
		location.setState("British Columbia");

		Location anotherLocation = new Location();
		anotherLocation.setCountry("Canada");
		anotherLocation.setState("Some state");

		locationRepository.saveAll(List.of(location, anotherLocation));
	}
	
	@Test
	public void testFindAll() {
		List<Location> locations = locationRepository.findAll();
		assertNotNull(locations);
	}

	@Test
	public void testSaveAndGetAndDelete(){
		Location location = new Location();
		location.setCountry("Canada");
		location.setState("British Columbia");
		location = locationRepository.save(location);

		Location otherLocation = locationRepository.findById(location.getId()).get();
		assertEquals("Canada", otherLocation.getCountry());
		assertEquals("British Columbia", otherLocation.getState());

		//delete BC location now
		locationRepository.delete(otherLocation);
	}

	@Test
	public void testFindWithLike(){
		List<Location> locations = locationRepository.findByStateLike("New%");
		assertEquals(4, locations.size());
	}

	@Test
	@Transactional  //note this is needed because we will get a lazy load exception unless we are in a tx
	public void testFindWithChildren() throws Exception {
		Location arizona = locationRepository.findById(3L).get();
		assertEquals("United States", arizona.getCountry());
		assertEquals("Arizona", arizona.getState());

		assertEquals(1, arizona.getManufacturers().size());

		assertEquals("Fender Musical Instruments Corporation", arizona.getManufacturers().get(0).getName());
	}

	@Test
	public void testFindWithAnd(){
		List<Location> locations = locationRepository.findByStateAndCountry("Some state", "Canada");
		assertEquals(1, locations.size());
	}

	@Test
	public void testFindWithOr(){
		List<Location> locations = locationRepository.findByStateOrCountry("Some state", "Canada");
		assertEquals(2, locations.size());
	}
}
