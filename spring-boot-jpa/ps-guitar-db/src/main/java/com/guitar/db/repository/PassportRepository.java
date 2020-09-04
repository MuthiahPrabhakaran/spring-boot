package com.guitar.db.repository;

import com.guitar.db.model.relationship.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}
