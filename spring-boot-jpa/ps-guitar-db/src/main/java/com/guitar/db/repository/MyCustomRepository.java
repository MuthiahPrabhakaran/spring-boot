package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyCustomRepository {
    @Query("select m from Model m")
    List<Model> customGetModels();
}
