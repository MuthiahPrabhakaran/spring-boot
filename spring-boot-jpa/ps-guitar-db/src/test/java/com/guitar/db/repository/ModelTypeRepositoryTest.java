package com.guitar.db.repository;

import com.guitar.db.model.ModelType;
import com.guitar.db.repository.ModelTypeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ModelTypeRepositoryTest {

    @Autowired
    public ModelTypeRepository modelTypeRepository;

    @Test
    public void testSave(){
        ModelType model = new ModelType();
        model.setName("test model");
        model = modelTypeRepository.save(model);

        ModelType anotherType = modelTypeRepository.findById(model.getId()).get();
        Assert.assertEquals("test model", anotherType.getName());
    }
}
