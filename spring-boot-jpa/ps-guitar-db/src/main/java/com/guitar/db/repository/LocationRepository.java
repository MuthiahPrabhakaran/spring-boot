package com.guitar.db.repository;


import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByStateLike(String stateName);

    List<Location> findByStateAndCountry(String stateName, String countryName);

    List<Location> findByStateOrCountry(String stateName, String countryName);

    List<Location> findByStateNot(String stateName);

    List<Location> findByStateIs(String stateName);

    List<Location> findByStateEquals(String stateName);

    List<Location> findByStateNotLike(String stateName);

    List<Location> findByStateStartingWith(String stateName);

    List<Location> findByStateEndingWith(String stateName);

    List<Location> findByStateContaining(String stateName);



}
