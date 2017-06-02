package com.example.ToDo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

/**
 * Created by Soren Ptak on 6/1/2017.
 */
//@EnableMongoRepositories(basePackages = "com.example.ToDo")
//@Service

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
