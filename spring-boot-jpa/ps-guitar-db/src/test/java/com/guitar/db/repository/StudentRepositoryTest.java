package com.guitar.db.repository;

import com.guitar.db.model.relationship.Passport;
import com.guitar.db.model.relationship.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@DataJpaTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
public class StudentRepositoryTest {

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public PassportRepository passportRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void initialize(){
        Passport p = new Passport();
        p.setPassportNumber("E12345");
        passportRepository.save(p);

        Student s = new Student();
        s.setId(101);
        s.setName("Krish");
        s.setPassport(p);

        studentRepository.save(s);
    }

    @Test
    public void testInsert(){
        Passport p = new Passport();
        p.setPassportNumber("P12345");
        passportRepository.save(p);

        Student s = new Student();
        s.setName("Student 1");
        s.setPassport(p);

        studentRepository.save(s);
        Student s2 = studentRepository.findAll().get(0);

        Assert.assertTrue(s2.getPassport().getPassportNumber().equals("P12345"));

    }

    @Test
    public void retrieveStudentWithPassport(){
        Student s3 = studentRepository.findById(20001).get();
        logger.info("Student Details -> {}",s3);
        logger.info("Passport Details -> {}",s3.getPassport());
    }
}
