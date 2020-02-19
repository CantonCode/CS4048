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
                ((MainActivity) getActivity()).order.put("Lasagna and Chips", 7.2);
                ((MainActivity) getActivity()).setViewPager(4);
                lasagna.setChecked(false);
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Chicken Roll and Chips", 5.0);
                ((MainActivity) getActivity()).setViewPager(4);
                chicken.setChecked(false);
            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Beef Burger and Chips",6.4);
                ((MainActivity) getActivity()).setViewPager(4);
                burger.setChecked(false);
            }
        });
        return view;
    }
}
