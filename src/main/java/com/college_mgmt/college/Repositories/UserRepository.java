package com.college_mgmt.college.Repositories;

import com.college_mgmt.college.Entites.Users;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<Users, Long>{
    Optional<Users> findByUsername(String username);
}
