package com.example.conor_firebase_wk2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class NewPost extends AppCompatActivity implements View.OnClickListener{

    private EditText userPost;
    private FirebaseAuth mAuth;

    ProgressDialog pd;

    FirebaseFirestore db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);


        pd = new ProgressDialog(this);

        db = FirebaseFirestore.getInstance();

        userPost = findViewById(R.id.postContent);

        findViewById(R.id.publishPost).setOnClickListener(this);
    }

    private void resetText(){
        userPost.setText(" ");
    }


    public void onClick(View v){
        int i = v.getId();

        if (i == R.id.publishPost){
            //code calling method to send the post to the server goes here

            String display = userPost.getText().toString().trim();

            uploadData(display);

            //Have the next line as the final call of this button click
            resetText();
        }
    }

    private void uploadData(String display) {

        pd.show();

        String id = UUID.randomUUID().toString();

        Map<String, Object> doc = new HashMap<>();
        doc.put("Username", id);
        doc.put("Post Description", display);

        //mAuth.createUserWithEmailAndPassword()
        db.collection("test").document(id).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                pd.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}


