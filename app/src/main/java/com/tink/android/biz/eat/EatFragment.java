package com.tink.android.biz.eat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tink.android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EatFragment extends Fragment {

    public EatFragment() {
        // Required empty public constructor
    }


    public static EatFragment newInstance() {
        EatFragment fragment = new EatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eat, container, false);
    }

}
