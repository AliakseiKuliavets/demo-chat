package com.example.demo.repository;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    @Query("select u from User u where u.username = userName")
    User findByUserName(String username);
}