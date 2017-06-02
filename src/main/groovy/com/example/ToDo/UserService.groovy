package com.example.ToDo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Soren Ptak on 6/1/2017.
 */
@Service
class UserService{
    @Autowired
    private UserRepository userRepository

    User findByuserName(String userName) {
        return(userRepository.findOne(userName))
    }
    User findByid(String id){
        return(userRepository.findOne(id))
    }

}
