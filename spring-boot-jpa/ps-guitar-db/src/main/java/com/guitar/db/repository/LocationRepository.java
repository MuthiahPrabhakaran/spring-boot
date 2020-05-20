package com.guitar.db.repository;


import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByStateLike(String stateName);

}
