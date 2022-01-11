package com.example.todo;



import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link List_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List_fragment extends Fragment  {
    ListView listView;
    FragmentListener fragmentListenerlist;
    String opertions,name;
    ArrayList<String> names;
    ArrayAdapter<String> arrayAdapter;
    Handler handler= new Handler();
    ArrayList<List> lists;
    View v;



    public interface FragmentListener
    {
        void action_input(String name,String operation);

    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public List_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment List_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static List_fragment newInstance(String param1, String param2) {
        List_fragment fragment = new List_fragment();
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
        v= inflater.inflate(R.layout.fragment_list_fragment, container, false);
        listView=v.findViewById(R.id.list);
        names=new ArrayList<>();



        return v;
    }

    public void update(String name,String operations)
    {
        this.name=name;
        this.opertions=operations;

        if(opertions.equals("delete")) {
            SparseBooleanArray sparseBooleanArray=listView.getCheckedItemPositions();
            for (int i = 0; i <=listView.getCount(); i++) {

                if(sparseBooleanArray.get(i)==true)


                {
try{
                    names.remove(i);}
catch (Exception e){
    Toast.makeText(getActivity(), "please try again"+e.getMessage(), Toast.LENGTH_SHORT).show();
}

                }

                arrayAdapter.notifyDataSetChanged();

            }
        }
        else if(opertions.equals("add"))
        {
            names.add(name);
        }

        arrayAdapter= new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_multiple_choice ,names);
        listView.setAdapter(arrayAdapter);
        handler.post(new Runnable() {
            @Override
            public void run() {
                listView.smoothScrollToPosition(arrayAdapter.getCount()-1);
            }
        });
    }
    public void updateDelete(String opertions) {




    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener)
        {
            fragmentListenerlist = (FragmentListener) context;
        }
        else
        {
            new RuntimeException(context.toString()+"must implement FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListenerlist =null;
    }
}