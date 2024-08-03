package com.example.goafinalproject.Discussion;

public class PostData {
    private String hashtag_post_title;
    private String hashtag_post_username;
    private String hashtag_post_text;
    private Integer post_image;
    private String post_time;
    private String likes;

    public PostData(String hashtag_post_title, String hashtag_post_username, String hashtag_post_text, Integer post_image, String post_time, String likes) {
        this.hashtag_post_title = hashtag_post_title;
        this.hashtag_post_username = hashtag_post_username;
        this.hashtag_post_text = hashtag_post_text;
        this.post_image = post_image;
        this.post_time = post_time;
        this.likes = likes;

    }

    public String getHashtag_post_title() {
        return hashtag_post_title;
    }

    public void setHashtag_post_title(String hashtag_post_title) {
        this.hashtag_post_title = hashtag_post_title;
    }

    public String getHashtag_post_username() {
        return hashtag_post_username;
    }

    public void setHashtag_post_username(String hashtag_post_username) {
        this.hashtag_post_username = hashtag_post_username;
    }

    public String getHashtag_post_text() {
        return hashtag_post_text;
    }

    public void setHashtag_post_text(String hashtag_post_text) {
        this.hashtag_post_text = hashtag_post_text;
    }

    public Integer getPost_image() {
        return post_image;
    }

    public void setPost_image(Integer post_image) {
        this.post_image = post_image;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
