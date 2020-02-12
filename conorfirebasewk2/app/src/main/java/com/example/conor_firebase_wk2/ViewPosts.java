package com.example.conor_firebase_wk2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;

public class ViewPosts extends AppCompatActivity implements View.OnClickListener {

    private TextView welcomeUser;
    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Posts");
    private PostAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_posts);

        welcomeUser = findViewById(R.id.welcome);

        findViewById(R.id.signOutButtonPost).setOnClickListener(this);
        findViewById(R.id.newPost).setOnClickListener(this);

        setUpRecyclerView();

    }

    public void setUpRecyclerView(){
        Query query = notebookRef.limit(5);

        FirestoreRecyclerOptions<Post> options = new FirestoreRecyclerOptions.Builder<Post>()
                .setQuery(query, Post.class)
                .build();

        adapter = new PostAdapter(options);

        recyclerView = findViewById(R.id.recyclerPosts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        welcomeUser.setText("Welcome: " + currentUser.getEmail());

        adapter.startListening();
    }

    protected void onStop(){
        super.onStop();

        adapter.stopListening();
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
