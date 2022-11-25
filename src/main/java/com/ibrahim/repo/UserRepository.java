package com.ibrahim.repo;

import com.ibrahim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


       User findUserByUserNameAndPassword(String userName,String Password);


}
