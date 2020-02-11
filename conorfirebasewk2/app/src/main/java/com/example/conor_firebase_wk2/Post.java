package com.example.conor_firebase_wk2;

public class Post {
    private String userEmail;
    private String postContent;
    private int postNum;

    public Post(){
        //empty constructor needed
    }

    public Post(String userEmail, String postContent){
        this.userEmail= userEmail;
        this.postContent=postContent;
//        this.postNum=postNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPostContent() {
        return postContent;
    }

//    public int getPostNum() {
//        return postNum;
//    }
}
