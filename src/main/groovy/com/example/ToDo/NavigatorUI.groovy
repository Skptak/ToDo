
package com.example.ToDo

import com.vaadin.annotations.Theme
import com.vaadin.navigator.Navigator
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.UI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


// Created by Soren Ptak on 5/29/2017.


@SpringUI
@Theme("valo")
@Service
class NavigatorUI extends UI{
    Navigator navigator
    protected static final String VIEW_NAME = "MAIN"


    @Autowired
    UserRepository userRepository

    @Override
    protected void init(VaadinRequest request){
        getPage().setTitle("Navigator")
        navigator = new Navigator(this,this)
        navigator.addView("CREATEUSERPAGE",new CreateUserPage(this))
        navigator.navigateTo("CREATEUSERPAGE")
    }

    void setTitle(String title){
        getPage().setTitle(title)
    }

    UserRepository getUserRepository() {
        return userRepository
    }

    void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository
    }
}
