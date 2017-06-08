package com.example.ToDo.Controller

import com.mongodb.Mongo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


/**
 * Created by Soren Ptak on 5/31/2017.
 * This is just the config class for the user repo
 */
@Configuration
@EnableMongoRepositories("com.example.ToDo")
class UserConfig extends AbstractMongoConfiguration{

    @Override
    protected String getDatabaseName(){
        return "User-Database"
    }
    @Override
    Mongo mongo() throws Exception {
        return new Mongo()
    }

    @Bean
    MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongo(),getDatabaseName())
    }

    @Override
    protected String getMappingBasePackage(){
        return "com.example.ToDo"
    }
}
