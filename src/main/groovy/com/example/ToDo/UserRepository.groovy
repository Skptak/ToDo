package com.example.ToDo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by Soren Ptak on 5/31/2017.
 */
@Repository
interface UserRepository extends MongoRepository<User, String>{

    User findByuserName(String userName)
    User findByid(String id)

}