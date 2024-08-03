package com.example.goafinalproject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public abstract class JSONParsable<T extends JSONParsable<T>> {
    //Requires: TreeMap<String, Object>, String
    //Modifies: this
    //Effects: Assigns all the properties to the values from the list, then execute the optional method props(String directory).
    public T parse(TreeMap<String, Object> list, String directory) throws IOException {
        properties().forEach(p -> {
            try {
                this.getClass().getDeclaredField(p).set(this, list.get(p));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
        });
        props(directory);
        return (T)this;
    }

    //Requires: TreeMap<String, Object>
    //Modifies: this
    //Effects: Assigns all the properties to the values from the list, then execute the optional method props().
    public T parse(TreeMap<String, Object> list) throws IOException {
        properties().forEach(p -> {
            try {
                this.getClass().getDeclaredField(p).set(this, list.get(p));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
        });
        props();
        return (T)this;
    }

    //Requires: Nothing
    //Modifies: Nothing
    //Effects: Returns the class
    public T getThis() {
        return (T)this;
    };

    //Requires: String
    //Modifies: Nothing
    //Effects: Optional method that executes after JSON is read if a directory is passed through
    public void props(String directory) throws IOException {};
    //Requires: Nothing
    //Modifies: Nothing
    //Effects: Optional method that executes after JSON is read if a directory is not passed through
    public void props() throws IOException {};

    //Requires: Nothing
    //Modifies: Nothing
    //Effects: Returns an ArrayList of the fields to be used by JSONParser
    public ArrayList<String> properties() {
        return new ArrayList<>(List.of(Arrays.stream(getThis().getClass().getDeclaredFields()).map(Field::getName).filter(f -> !f.equals("properties")).toArray(String[]::new)));
    };
}
