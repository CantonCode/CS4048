package com.example.restaurantmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class lunch extends Fragment {

    private CheckBox lasagna;
    private CheckBox chicken;
    private CheckBox burger;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lunch, container, false);

        lasagna= (CheckBox) view.findViewById(R.id.lasagna);
        chicken = (CheckBox) view.findViewById(R.id.chicken);
        burger = (CheckBox) view.findViewById(R.id.burger);

        lasagna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order += "Lasagna and Chips\n";
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order += "Chicken Roll and Chips\n";
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order += "Beef Burger and Chips\n";
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });
        return view;
    }
}
