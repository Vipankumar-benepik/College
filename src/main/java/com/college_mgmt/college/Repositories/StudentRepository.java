package com.college_mgmt.college.Repositories;

import com.college_mgmt.college.Entites.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends GenericRepository<Student, Long>{
}
