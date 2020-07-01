package com.guitar.db.repository;

import com.guitar.db.model.ModelType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;

public interface ModelTypeRepository extends JpaRepository<ModelType, Long> {
    
    List<ModelType> findByNameIsNull();
    List<ModelType> findByNameIsNotNull();
    List<ModelType> findByNameNotNull();


}
