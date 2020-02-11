package com.example.conor_firebase_wk2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ViewPosts extends AppCompatActivity implements View.OnClickListener {

    private TextView welcomeUser;
    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_posts);

        welcomeUser = findViewById(R.id.welcome);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signOutButtonPost).setOnClickListener(this);
        findViewById(R.id.newPost).setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerPosts);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        welcomeUser.setText("Welcome: " + currentUser.getEmail());
    }


    private void signOut() {
        mAuth.signOut();
        Intent intent = new Intent(this, EmailPasswordActivity.class);
        startActivity(intent);
    }

    private void toNewPost(){
        Intent intent = new Intent(this, NewPost.class);
        startActivity(intent);
    }

    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.signOutButtonPost){
            signOut();
        }

        if ( i == R.id.newPost){
            toNewPost();
        }
    }


}
