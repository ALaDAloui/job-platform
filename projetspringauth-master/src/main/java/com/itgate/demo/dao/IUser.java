package com.itgate.demo.dao;
import java.util.List;

import com.itgate.demo.DTOs.MiniUserProfile;
import com.itgate.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser  extends JpaRepository<User,Long> {

    /*@Query("{'username':?0}")*/
     @Query("select u from  User  u where u.username= :username")
    User findByUsername(@Param("username") String username);

     
     //List<User> getUsers();

     //User getUser(int id);

    // MiniUserProfile getMiniUserProfile(int id);
}