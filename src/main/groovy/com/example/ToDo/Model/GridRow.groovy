package com.example.ToDo.Model

/**
 * Created by Soren Ptak on 6/7/2017.
 */
class GridRow {

    private int key
    private String value
    GridRow(int myKey, String myValue){
        key = myKey
        value = myValue
    }

    String getKey() {
        return key
    }

    String getValue() {
        return value
    }
}
