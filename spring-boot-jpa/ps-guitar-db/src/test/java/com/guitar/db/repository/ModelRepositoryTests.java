package com.guitar.db.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.guitar.db.model.ModelType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.guitar.db.model.Model;


@DataJpaTest
@RunWith(SpringRunner.class)
public class ModelRepositoryTests {

	@Autowired
	private ModelRepository modelRepository;

	@Autowired
	private ModelTypeRepository modelTypeRepository;

	List<String> modelNames = Arrays.asList("Semi-Hollow Body Electric");

	@Before
	public void initializeRepository(){

		ModelType model1, model2, model3, model4, model5, model6, model7;

		model1 = new ModelType(1L,"Dreadnought Acoustic");
		model2 = new ModelType(2L,"Nylon String Acoustic");
		model3 = new ModelType(3L,"Acoustic Electric");
		model4 = new ModelType(4L,"Electric");
		model5 = new ModelType(5L,"Hollow Body Electric");
		model6 = new ModelType(6L,"Semi-Hollow Body Electric");
		model7 = new ModelType(7L, "Bass");

		List<ModelType> modelTypes = List.of(model1, model2, model3, model4, model5, model6, model7);
		modelTypeRepository.saveAll(modelTypes);
		modelTypeRepository.flush();

		List<Model> models = List.of(new Model("American Stratocaster", BigDecimal.valueOf(1000), "Maple", model4),
				new Model("American Telecaster",BigDecimal.valueOf(800), "Maple", model4),
				new Model("King",BigDecimal.valueOf(600), "Variety of high quality woods", model6),
				new Model("Precision Bass",BigDecimal.valueOf(900), "Alder and Ash", model7),
				new Model("Les Paul",BigDecimal.valueOf(1600), "Mahogany and Maple", model4),
				new Model("SG",BigDecimal.valueOf(1200), "Birch and Maple", model4),
				new Model("ES-335",BigDecimal.valueOf(2200), "Maple and Rosewood", model6),
				new Model("Hummingbird",BigDecimal.valueOf(900), "Spruce and Mahogany", model1));
		modelRepository.saveAll(models);
		modelRepository.flush();
	}


	@Test
	@Transactional
	public void testSaveAndGetAndDelete() throws Exception {
		Model m = new Model();
		m.setFrets(10);
		m.setName("Test Model");
		m.setPrice(BigDecimal.valueOf(55L));
		m.setWoodType("Maple");
		m.setModelType(new ModelType(7L, "Bass"));
		m.setYearFirstMade(new Date());
		m = modelRepository.save(m);

		Model otherModel = modelRepository.findById(m.getId()).get();
		assertEquals("Test Model", otherModel.getName());
		assertEquals(10, otherModel.getFrets());
		
		//delete BC location now
		modelRepository.delete(otherModel);
	}

	@Test
	public void testQueryByPriceAndWood(){
		List<Model> models = modelRepository.queryByPriceRangeAndWoodType(BigDecimal.valueOf(600),BigDecimal.valueOf(1500), "%Maple%");
		assertEquals(models.size(), 3);
	}

	@Test
	public void testFindByModelTypeNameIn(){
		List<Model> resultModels = modelRepository.findByModelTypeNameIn(modelNames);
		assertEquals(resultModels.size(), 2);
	}

	@Test
	public void testFindByModelTypeNameNotIn(){
		List<Model> resultModels = modelRepository.findByModelTypeNameNotIn(modelNames);
		assertEquals(resultModels.size(), 6);
	}

}
