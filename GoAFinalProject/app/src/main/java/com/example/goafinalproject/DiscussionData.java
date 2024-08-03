package com.example.goafinalproject;

import android.graphics.Bitmap;

public class DiscussionData {

    private String title;
    private String username;
    private String discussiondescription;
    private String datediscussion;
    private String likes;
    private Bitmap discussionphoto;



    public DiscussionData(String title, String username, String discussiondescription, String datediscussion, String likes, Bitmap discussionphoto) {
        this.title = title;
        this.username = username;
        this.discussiondescription = discussiondescription;
        this.datediscussion = datediscussion;
        this.likes = likes;
        this.discussionphoto = discussionphoto;
    }

    @Override
    public String toString() {
        return "DiscussionData{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", discussiondescription='" + discussiondescription + '\'' +
                ", datediscussion='" + datediscussion + '\'' +
                ", likes='" + likes + '\'' +
                ", discussionphoto=" + discussionphoto +
                '}';
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiscussiondescription() {
        return discussiondescription;
    }

    public void setDiscussiondescription(String discussiondescription) {
        this.discussiondescription = discussiondescription;
    }

    public String getDatediscussion() {
        return datediscussion;
    }

    public void setDatediscussion(String datediscussion) {
        this.datediscussion = datediscussion;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Bitmap getDiscussionphoto() {
        return discussionphoto;
    }

    public void setDiscussionphoto(Bitmap discussionphoto) {
        this.discussionphoto = discussionphoto;
    }

//to string
}
