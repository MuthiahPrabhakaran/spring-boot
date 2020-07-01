package com.guitar.db.impl;

import com.guitar.db.model.Model;
import com.guitar.db.repository.MyCustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MyCustomRepositoryImpl implements MyCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Model> customGetModels() {
        return entityManager.createQuery("Select m from Model m").getResultList();
    }
}
