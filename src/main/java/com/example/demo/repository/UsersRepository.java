package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    List<Users> findByActiveFlagAndUserIdAndPassword(boolean activeFlag, String userId, String password);
}