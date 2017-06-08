package com.example.ToDo.View

import com.example.ToDo.Controller.NavigatorUI
import com.example.ToDo.Model.User
import com.example.ToDo.Model.UserRepository
import com.vaadin.navigator.Navigator
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Button
import com.vaadin.ui.Label
import com.vaadin.ui.Notification
import com.vaadin.ui.PasswordField
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout

import java.nio.charset.StandardCharsets
import java.security.MessageDigest


/**
 * Created by Soren Ptak on 5/28/2017.
 */

@SpringView(name = CreateUserPage.VIEW_NAME)
class CreateUserPage extends VerticalLayout implements  View{
    private Navigator navigator
    private NavigatorUI navigatorUI
    private UserRepository userRepository

    protected static final String VIEW_NAME = "CREATEUSERPAGE"
    CreateUserPage(NavigatorUI navUI){
        navigator = navUI.getNavigator()
        navigatorUI = navUI
        userRepository = navUI.getUserRepository()
        navigatorUI.setTitle("Create User")
        setupLayout()
    }

    //Adds all the buttons and a label
    private void setupLayout(){
        Label myLabel = new Label("Please create an account")
        TextField userField = new TextField("Provide a username, must be at least 1 character")
        PasswordField firstPass = new PasswordField("Please provide a password, must be at least 1 character")
        PasswordField secondPass = new PasswordField("Must match the password")
        Button create = new Button("Create account")
        addComponents(myLabel,userField,firstPass,secondPass,create)

        //Checks to make sure the username and passwords are fine when the user hits okay
        create.addClickListener({click ->
            if((userField.getValue().size() < 1)){
                Notification.show("That username is too short")
                userField.clear()
            }
            else if(firstPass.getValue() != secondPass.getValue()){
                Notification.show("The two passwords do not match")
                firstPass.clear()
                secondPass.clear()
            }
            else if(firstPass.getValue().size() < 1){
                Notification.show("The password is too short")
                firstPass.clear()
                secondPass.clear()
            }
            //If everything is fine, creates the user, adds to the repo, and move to the table
            else{
                MessageDigest digest = MessageDigest.getInstance("SHA-256")
                byte[] hash = digest.digest(firstPass.getValue().getBytes())
                String myString = new String(hash)
                User myUser = new User(userField.getValue(),myString)
                userRepository.insert(myUser)
                UserPage myPage = new UserPage(navigatorUI,myUser)
                navigator.addView("USERPAGE",myPage)
                navigator.navigateTo("USERPAGE")
            }


        }as Button.ClickListener)

    }
    @Override
    void enter(ViewChangeEvent event){
    }


}
