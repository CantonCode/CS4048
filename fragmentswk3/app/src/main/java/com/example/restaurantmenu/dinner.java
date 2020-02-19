package com.example.restaurantmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class dinner extends Fragment {

    private CheckBox pizza;
    private CheckBox chickenC;
    private CheckBox fish;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main, container, false);

        pizza = (CheckBox) view.findViewById(R.id.pizza);
        chickenC = (CheckBox) view.findViewById(R.id.chickenC);
        fish  = (CheckBox) view.findViewById(R.id.fish);

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Pizza and Chips", 7.2);
                ((MainActivity) getActivity()).setViewPager(4);
                pizza.setChecked(false);
            }
        });

        chickenC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Chicken Curry and Chips", 9.5);
                ((MainActivity) getActivity()).setViewPager(4);
                chickenC.setChecked(false);
            }
        });

        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order.put("Fish and Chips", 10.0);
                ((MainActivity) getActivity()).setViewPager(4);
                fish.setChecked(false);
            }
        });
        return view;
    }
}
