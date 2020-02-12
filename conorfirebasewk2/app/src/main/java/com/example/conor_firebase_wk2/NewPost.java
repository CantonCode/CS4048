package com.example.conor_firebase_wk2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class NewPost extends AppCompatActivity implements View.OnClickListener{

    private EditText userPost;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ProgressDialog pd;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        userPost = findViewById(R.id.postContent);
        pd  = new ProgressDialog(this);

        findViewById(R.id.publishPost).setOnClickListener(this);
    }

    private void resetText(){

        userPost.setText(" ");
    }


    public void onClick(View v){
        int i = v.getId();

        if (i == R.id.publishPost){
            String display = userPost.getText().toString().trim();
            uploadData(display);
        }
    }

    private void uploadData(String display) {

        pd.show();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        String user = currentUser.getEmail();
        Map<String, Object> doc = new HashMap<>();
        doc.put("Username",user);
        doc.put("Content", display);

        //mAuth.createUserWithEmailAndPassword()
        db.collection("Posts").document(user).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pd.dismiss();

                Toast.makeText(NewPost.this,
                        "New Post Created",
                        Toast.LENGTH_SHORT).show();

                resetText();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NewPost.this,
                        "Failed TO Create New Post",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}


