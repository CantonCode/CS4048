package com.example.conor_firebase_wk2;

public class Post {
    private String username;
    private String content;
    private int postNum;

    public Post(){
        //empty constructor needed
    }


    public Post(String Username, String Content){
        this.username = Username;
        this.content = Content;
//        this.postNum=postNum;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public int getPostNum() {
//        return postNum;
//    }

}
