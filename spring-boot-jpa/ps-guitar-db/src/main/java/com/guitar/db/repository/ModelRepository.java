package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findByModelTypeNameIn(List<String> model);
    List<Model> findByModelTypeNameNotIn(List<String> model);
}
