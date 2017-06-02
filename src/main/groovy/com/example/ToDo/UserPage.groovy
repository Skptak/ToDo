package com.example.ToDo

import com.vaadin.annotations.DesignRoot
import com.vaadin.navigator.Navigator
import com.vaadin.navigator.View
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Grid
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent

/**
 * Created by Soren Ptak on 5/28/2017.
 */
@DesignRoot
@SpringView(name = com.example.ToDo.UserPage.VIEW_NAME)
class UserPage extends VerticalLayout implements  View {
    NavigatorUI navigatorUI
    User user
    public static final String VIEW_NAME = "USERPAGE"

    UserPage(NavigatorUI myNav, User myUser) {
        navigatorUI = myNav
        user = myUser
        addLabel()
        createTable()
        navigatorUI.setTitle("User Page")
        
    }

    @Override
    void enter(ViewChangeEvent event) {
    }

    //The table appears to have been removed in recent Vaadin, so now it's a grid
    void createTable(){

        Grid<User> grid = new Grid<>(User.class)
        grid.setItems(user)
        grid.setColumns("userName","userMap","ints","strings")

        //Set it so the individual columns can be collapsed
        grid.getColumn("userName").setHidable(true)
        grid.getColumn("ints").setHidable(true)
        grid.getColumn("strings").setHidable(true)
        grid.getColumn("userMap").setHidable(true)
        grid.setSizeUndefined()
        addComponent(grid)
    }

    void addLabel(){
        Label myLabel = new Label("Welcome " + user.getuserName())
        addComponent(myLabel)
    }
}
