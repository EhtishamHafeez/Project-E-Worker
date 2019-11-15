package com.example.projectphase1.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a17l_4343_ui_design.MyTasksClass;
import com.example.a17l_4343_ui_design.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchFragment extends Fragment {

    View view;
    private RecyclerView myRecyclerView;
    private List<MyTasksClass> myList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=  inflater.inflate(R.layout.search_fragment_layout,container,false);
        myRecyclerView = view.findViewById(R.id.mytaskview);
        MyTaskAdopter recyclerViewAdopter = new MyTaskAdopter(getContext(),myList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdopter);
        return  view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myList = new ArrayList<MyTasksClass>();
        for (int i = 0; i < 9; i++) {
            if(i%2==0)
                 myList.add(new MyTasksClass(i + 1, 1, "Electrician", 2, 1220, new Date(), "Lahore", R.drawable.job_electrician));
            else
                myList.add(new MyTasksClass(i + 1, 2, "CarPainter", 1, 900, new Date(), "Karachi", R.drawable.pass2));
        }
    }
}
