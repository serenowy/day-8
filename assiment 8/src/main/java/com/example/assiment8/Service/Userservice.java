package com.example.assiment8.Service;


import com.example.assiment8.Exception.ApiException;
import com.example.assiment8.Repository.UserRepository;
import com.example.assiment8.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Userservice {
    private final UserRepository userRepository;
    public List<User> getUser() {
        return userRepository.findAll();
    }
    public void addUser(User user){
       userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user){
        User olduser=userRepository.findUserById(id);
        if(olduser==null){
            return false;
        }

        olduser.setName(user.getName());
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setAge(user.getAge());

       userRepository.save(olduser);
        return true;
    }
    public boolean deleteUser(Integer id){
      User user=userRepository.findUserById(id);
        if(user==null){
            return false;

        }
     userRepository.delete(user);
        return true;
    }
    public User getUserById(Integer id){
       User user =userRepository.findUserById(id);
        if(user==null){throw new ApiException("wrong Id");}
        return user;
    }
    public User getUserByEmail(String email){
        User user =userRepository.findUserByEmail(email);
        if(user==null){throw new ApiException("wrong email");}
        return user;
    }
    public User getUserByUsernameAndPassword(String username  , Integer password){
        User user =userRepository.findUserByUsernameAndPassword(username,password);
        if(user==null){throw new ApiException("wrong username or password");}
        return user;
    }
    public  List<User> getAllByRole(String role){
        List<User>  user =userRepository.findAllByRole(role);
        if(user.isEmpty()){throw new ApiException("No users have this role");}
        return user;
    }


    /*Get All users with specific age or above*/
    public List<User> getUsersByAge(Integer age) {
        List<User>  user =userRepository.findAllByAgeGreaterThanEqual(age);
        if(user.isEmpty()){throw new ApiException("No users of this age or older");}
        return user;
    }

}
