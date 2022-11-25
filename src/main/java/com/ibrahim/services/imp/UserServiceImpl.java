package com.ibrahim.services.imp;

import com.ibrahim.entity.User;
import com.ibrahim.repo.UserRepository;
import com.ibrahim.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userrepository;



    @Override
        public Boolean userCheck(String userName,String Password) {
         Optional<User> userslist= Optional.ofNullable(userrepository.findUserByUserNameAndPassword(userName, Password));
        if (userslist.isEmpty()){
            return  false;
        }
        else
        {
        return true;}
    }



}
