package com.example.goafinalproject;
//*didn't do it for the image

import android.graphics.Bitmap;
import android.media.Image;

//model class
public class EventsCards {
    private int id;


    private Bitmap imageView;
    private String title;
    private String date;
    private String time;
    private String locationDescription;
    private String streetAddress;
    private String city_province;
    private String postalCode;

    public EventsCards(int id, Bitmap imageView, String title, String date, String time, String locationDescription, String streetAddress, String city_province, String postalCode) {
        this.id = id;
        this.imageView = imageView;
        this.title = title;
        this.date = date;
        this.time = time;
        this.locationDescription = locationDescription;
        this.streetAddress = streetAddress;
        this.city_province = city_province;
        this.postalCode = postalCode;
    }

    //getters and setters
        //tostring method, concatinates info

    //constructor
    @Override
    public String toString() {
        return "events_pg{" +
                "id=" + id +
                ", imageView = ' " + imageView +'\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + locationDescription + '\'' +
                ", address='" + streetAddress + '\'' +
                ", cityProvince='" + city_province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
        //lets us know which items are added/deleted

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImageView() {
        return imageView;
    }

    public void setImageView(Bitmap imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity_province() {
        return city_province;
    }

    public void setCity_province(String city_province) {
        this.city_province = city_province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
