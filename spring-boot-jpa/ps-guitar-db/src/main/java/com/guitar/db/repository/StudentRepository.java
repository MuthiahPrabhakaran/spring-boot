package com.guitar.db.repository;

import com.guitar.db.model.relationship.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
