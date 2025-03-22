package com.example.User.repository;


import com.example.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Additional query methods can be defined here if needed
    User findByName(String name);

    User findByNameAndEmail(String name,String email);
}