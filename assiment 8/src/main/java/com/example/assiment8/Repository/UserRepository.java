package com.example.assiment8.Repository;

import com.example.assiment8.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {

  User findUserById( Integer id);
  User findUserByUsernameAndPassword(String username  , Integer password );
    User findUserByEmail(String email);


    List<User>findAllByRole(String role);

  List<User> findAllByAgeGreaterThanEqual(Integer age);



}
