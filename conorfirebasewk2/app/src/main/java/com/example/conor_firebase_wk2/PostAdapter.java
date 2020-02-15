package com.example.conor_firebase_wk2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PostAdapter extends FirestoreRecyclerAdapter<Post,PostAdapter.PostHolder>{

    private static final String TAG = "MyActivity";

    public PostAdapter(@NonNull FirestoreRecyclerOptions<Post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostHolder holder, int position, @NonNull Post model) {
        holder.textViewEmail.setText(model.getUsername());
        holder.textViewContent.setText(model.getContent());
        Log.i(TAG, holder.textViewEmail.getText().toString());
        Log.i(TAG, holder.textViewContent.getText().toString());

    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostHolder(v);
    }

    class PostHolder extends RecyclerView.ViewHolder{
        TextView textViewEmail;
        TextView textViewContent;

        public PostHolder(View itemView){
            super(itemView);

            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewContent = itemView.findViewById(R.id.textViewContent);

        }

    }
}
