package com.example.restaurantmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class starter extends Fragment {

    private CheckBox soup;
    private CheckBox salad;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.starters, container, false);

        soup = (CheckBox) view.findViewById(R.id.soup);
        salad = (CheckBox) view.findViewById(R.id.salad);

        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order += "Soup\n";
                ((MainActivity) getActivity()).setViewPager(3);
            }
        });

        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).order += "Salad\n";
                ((MainActivity) getActivity()).setViewPager(3);
            }
        });

        return view;
    }
}
