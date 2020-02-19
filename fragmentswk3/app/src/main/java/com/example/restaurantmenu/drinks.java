package com.example.restaurantmenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class drinks extends Fragment {

    private CheckBox guinness;
    private CheckBox coke;
    private CheckBox fanta;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drinks, container, false);

        guinness = (CheckBox) view.findViewById(R.id.guinness);
        coke = (CheckBox) view.findViewById(R.id.coke);
        fanta = (CheckBox) view.findViewById(R.id.fanta);

        guinness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Guinness", 4.2);
                ((MainActivity) getActivity()).setViewPager(5);
                guinness.setChecked(false);
            }
        });

        coke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Coke", 2.5);
                ((MainActivity) getActivity()).setViewPager(5);
                coke.setChecked(false);
            }
        });

        fanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Fanta", 2.5);
                ((MainActivity) getActivity()).setViewPager(5);
                fanta.setChecked(false);
            }
        });
        return view;
    }

}
