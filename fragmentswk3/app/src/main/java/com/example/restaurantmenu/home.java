package com.example.restaurantmenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class home extends Fragment {
    private static final String TAG ="home";

    private Button btnlunch;
    private Button btndinner;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        btnlunch = (Button) view.findViewById(R.id.btnLunch);
        btndinner = (Button) view.findViewById(R.id.btnDinner);
        Log.d(TAG, "onCreateView: started.");

        btnlunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(1);
            }
        });

        btndinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(2);
            }
        });

        return view;
    }
}
