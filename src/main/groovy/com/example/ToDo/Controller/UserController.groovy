package com.example.ToDo.Controller

import com.example.ToDo.Model.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

/**
 * Created by Soren Ptak on 6/1/2017.
 */
@Controller
class UserController {
    @Autowired
    private UserService userService
}
