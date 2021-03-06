package com.se.device.service;

import com.se.device.entity.DeviceBorrow;
import com.se.device.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where username=?1 and password=?2 and status='true'", nativeQuery = true)
    public List<User> findUserByUsernameAndPassword(String username, String password);


    @Query(value = "select * from user where id=?1", nativeQuery = true)
    public User findOneById(String id);


    @Transactional
    @Modifying
    @Query(value = "insert into user(username, password) values(?1, ?2)", nativeQuery = true)
    public void insertUser(String username, String password);



    @Query(value = "select * from user order by create_time desc, id desc limit ?1, ?2", nativeQuery = true)
    public List<User> findAllToPage(int page, int limit);

}
