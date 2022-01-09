package com.example.todo;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class action_fragment extends Fragment {
    Button add,delete;
    EditText name;
    FragmentListener fragmentListener;
    public interface FragmentListener
    {
        void action_input(String name,String operation);
    }
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public action_fragment() {
        // Required empty public constructor
    }


    public static action_fragment newInstance(String param1, String param2) {
        action_fragment fragment = new action_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_action_fragment, container, false);
        add=v.findViewById(R.id.add);
        delete=v.findViewById(R.id.delete);
        name=v.findViewById(R.id.name);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameinput=name.getText().toString();
                fragmentListener.action_input(nameinput,"add");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.action_input("","delete");
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener)
        {
            fragmentListener= (FragmentListener) context;
        }
        else
        {
            new RuntimeException(context.toString()+"must implement FragmentListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener=null;
    }


}
