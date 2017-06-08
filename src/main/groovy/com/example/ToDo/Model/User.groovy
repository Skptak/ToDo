package com.example.ToDo.Model

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by Soren Ptak on 5/27/2017.
 */
@Document
class User{

    @Id
    private String id
    private String userName
    private String hashedPassword
    private HashMap<Integer,ArrayList<String>> userMap
    private ArrayList<String> ints

    private ArrayList<ArrayList<String>> strings
    User(@Value("#root.ID")String ID, @Value("#root.password")String password){
        userMap = new HashMap<Integer,ArrayList<String>>()
        ints = new ArrayList<String>()
        strings = new ArrayList<ArrayList<String>>()

        populateMap()
        id = ID
        userName = ID
        hashedPassword = password
    }

    //Creates a default map for testing/Showing
    private void populateMap(){
        ArrayList<String> myValues = new ArrayList<String>()
        String myStr = "String"
        int count = 1
        for(int i = 1; i < 4;i++){
            for(int j = 1; j < 4; j++ ){
                ints.add(i.toString())
                myValues.add(myStr+count)
                count++
            }
            userMap.put(i,myValues)
            myValues = new ArrayList<String>()
        }
        strings = userMap.values()
    }

    @Override
    boolean equals(Object obj) {
        if(obj == null){
            return(false)
        }
        if(obj.getClass() == this.getClass()) {
            if(this.compareTo((User)obj) == 0){
                return(true)
            }
        }
        return(false)
    }


    int compareTo(User other){
        if(id == other.id) {
            if(hashedPassword == other.hashedPassword){
                if(userMap.equals(other.userMap)){
                    return(0)
                }
            }
        }
        return(-1)
    }

    String getid() {
        return id
    }
    String getHashedPass(){
        return(hashedPassword)
    }

    String getuserName(){
        return userName
    }

    HashMap<Integer, ArrayList<String>> getUserMap() {
        return userMap
    }

    ArrayList<String> getList(int myInt){
        return(new ArrayList<String>(userMap.get(myInt)))
    }

    ArrayList<String> getInts() {
        return ints
    }

    ArrayList<ArrayList<String>> getStrings() {
        return strings
    }
}
