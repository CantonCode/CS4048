package com.example.conor_firebase_wk2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class NewPost extends AppCompatActivity implements View.OnClickListener{

    private EditText userPost;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);


        userPost = findViewById(R.id.postContent);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.publishPost).setOnClickListener(this);
    }

    private void resetText(){

        userPost.setText(" ");
    }


    public void onClick(View v){
        int i = v.getId();

        if (i == R.id.publishPost){
            //code calling method to send the post to the server goes here

            //Have the next line as the final call of this button click
            resetText();
        }
    }
}
