package com.example.goafinalproject.Discussion;

public class CommentData {
    private String comment_text;
    private String comment_username;

    public CommentData(String comment_text, String comment_username) {
        this.comment_text = comment_text;
        this.comment_username = comment_username;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_username() {
        return comment_username;
    }

    public void setComment_username(String comment_username) {
        this.comment_username = comment_username;
    }
}
