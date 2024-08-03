package com.example.goafinalproject;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Pattern;

@SuppressWarnings({"unused", "rawtypes", "unchecked"})
public class JSONParser {
    private static ArrayList<JSONParsable<? extends JSONParsable>> objects = new ArrayList<>();

    //Requires: String, Class that extends JSONParsable
    //Modifies: objects
    //Effects: Parse JSON into ArrayList 'objects' without passing through directory.
    public static ArrayList<? extends JSONParsable> parseJSON(String fileName, Class<? extends JSONParsable> type) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<? extends JSONParsable> _return = parseJSON(br, type, false);
        fr.close();
        return _return;
    }

    //Requires: String, Class that extends JSONParsable
    //Modifies: objects
    //Effects: Parse JSON into ArrayList 'objects' without passing through directory.
    public static ArrayList<? extends JSONParsable> parseJSON(BufferedReader br, Class<? extends JSONParsable> type) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return parseJSON(br, type, false);
    }

    //Requires: String, Class that extends JSONParsable, boolean
    //Modifies: objects
    //Effects: Parse JSON into ArrayList 'objects' with option to pass through directory.
    public static ArrayList<? extends JSONParsable> parseJSON(BufferedReader br, Class<? extends JSONParsable> type, boolean passFileName) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        objects.clear(); //Clear the objects ArrayList
        //Read from file:
//        FileReader fr = new FileReader(fileName);
//        BufferedReader br = new BufferedReader(fr);
        String line;
        StringBuilder lines = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (!line.equals("[") & !line.equals("]")) { //Remove the ['s and ]'s
                lines.append(line);
            }
        }
        //Split each object by the "}," and store in new ArrayList:
        ArrayList<String> objectList = new ArrayList<>(List.of(lines.toString().split(Pattern.quote("},"))));
        TreeMap<String, TreeMap<String, Object>> objectMap = new TreeMap<>(); //TreeMap to hold all the properties of each object.
        //For each object in objectList:
        for (String i : objectList) {
            //Remove all {'s and }'s:
            String s = i.replaceAll("\\{", "").replaceAll(Pattern.quote("}"), "");
            //Initialize the TreeMap for each object:
            objectMap.put(s, new TreeMap<>());
            //For each substring in the object split by commas not surrounded by quotations:
            for (String x : s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) {
                if (x.split(": ").length == 2) { //Each string split by ":" should have a key and a value.
                    String regex = "\\s+(?=((\\\\[\\\\\"]|[^\\\\\"])*\"(\\\\[\\\\\"]|[^\\\\\"])*\")*(\\\\[\\\\\"]|[^\\\\\"])*$)";
                    //Put the key and value in the object's treemap:
                    objectMap.get(s).put(
                            x.split(": ")[0] //Key
                                .replaceAll(regex, "") //Replace all whitespace not in quotations in key.
                                .replaceAll("\"", ""), //Replace all quotation marks in key.
                            x.split(": ")[1] //Value
                                    .replaceAll(regex, "") //Replace all whitespace not in quotations in key.
                                    .replaceAll("\"", "") //Replace all quotation marks in key.
                                    .replaceAll("\\[", "{") //Replace all ['s in key.
                                    .replaceAll("]", "}") //Replace all ]'s in key.
                                    .replaceAll("'", "\"") //Replace all ''s in key.
                                    .replaceAll(";", ",")); //Replace all semicolons in key.
                }
            }
            if (passFileName) { //If pass file name, add a new instance of an object to objects and call parse with directory:
                objects.add(type.getDeclaredConstructor().newInstance().parse(objectMap.get(s)));
            } else { //Otherwise, add a new instance of an object to objects and call parse without directory:
                objects.add(type.getDeclaredConstructor().newInstance().parse(objectMap.get(s)));
            }
        }
        br.close();
        return objects;
    }

    //Write JSON to file.
    public static void writeJSON(String fileName, ArrayList<? extends JSONParsable> objectsToWrite, ArrayList<String> properties) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("["); //Write opening square bracket
        //For each object in objectsToWrite:
        for (int i = 0; i < objectsToWrite.size(); i++) {
            JSONParsable<?> object = objectsToWrite.get(i);
            bw.append("\n\t{"); //Append object opening "{"
            //For each property in object:
            properties.forEach(p -> {
                try {
                    bw.append("\n\t\"") //Append new line and opening key quotation
                        .append(p) //Append property key
                        .append("\": \"") //Append closing key quotation, ":", and opening value quotation
                        .append(String.valueOf(object.getClass().getDeclaredField(p).get(object))) //Append property value
                        .append("\""); //Append closing value quotation
                    if (properties.size()-1 > properties.indexOf(p)) {bw.append(",");} //Append comma if it is not the last property
                } catch (IOException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                    throw new RuntimeException(e.getLocalizedMessage());
                }
            });
            bw.append("\n\t}"); //Append object closing "{"
            if (!(i == objectsToWrite.size() - 1)) {bw.append(",");} //Append comma if it is not the last object
        }
        bw.append("\n]"); //Append closing square bracket
        bw.close();
    }
}
