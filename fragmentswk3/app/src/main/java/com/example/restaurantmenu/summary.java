package com.example.restaurantmenu;

import android.os.Bundle;
import android.util.Log;
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
import java.util.Set;

public class summary extends Fragment {

    private TextView text2;
    private TextView text4;
    private Button btnok;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary, container, false);
        btnok = view.findViewById(R.id.ok);

        text2 = view.findViewById(R.id.textView2);
        text4 = view.findViewById(R.id.textView4);

        Set<String> keys= ((MainActivity)getActivity()).order.keySet();

        double total=0;

        for (String key: keys) {
            Log.d("key", key);
            text2.append(key + " ");
            text2.append((((MainActivity)getActivity()).order.get(key)).toString() + "\n");
            total+=((MainActivity)getActivity()).order.get(key);
        }

        text4.append("€" + total);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).order.clear();
                ((MainActivity) getActivity()).setViewPager(0);
            }
        });
        return view;
    }
}
