package com.example.restaurantmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class summary extends Fragment {

    private TextView text2;
    private Button btnok;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary, container, false);
        btnok = view.findViewById(R.id.ok);

        text2 = view.findViewById(R.id.textView2);
        text2.setText(((MainActivity)getActivity()).order);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).order = "";
                ((MainActivity) getActivity()).setViewPager(0);
            }
        });
        return view;
    }
}
